package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Aleksandr on 03.06.2017.
 */
public class HtmlView implements View {

    private Controller controller;
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replaceAll("\\.", "/") + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) throws IOException {
        updateFile(getUpdatedFileContent(vacancies));
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() throws IOException {
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) throws IOException {

        Document document;
        try {

            document = getDocument();

            Element element = document.getElementsByClass("template").first();
            Element copyElement = element.clone();

            copyElement.removeAttr("style");
            copyElement.removeClass("template");

            document.select("tr[class=vacancy]").remove().not("tr[class=vacancy template]");

            for (Vacancy vacancy : vacancies) {
                Element element1 = copyElement.clone();
                element1.getElementsByClass("city").first().text(vacancy.getCity());
                element1.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                element1.getElementsByClass("salary").first().text(vacancy.getSalary());
                Element a = element1.getElementsByTag("a").first();
                a.text(vacancy.getTitle());
                a.attr("href", vacancy.getUrl());

                element.before(element1.outerHtml());

            }
        }catch (Exception e){
            e.printStackTrace();
            return "Some exception occurred";
        }

        return document.html();
    }

    private void updateFile(String string) throws IOException {

        try(FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath))) {

            byte[] bytes = string.getBytes();
            fileOutputStream.write(bytes, 0, bytes.length);
        }catch (IOException e) {
            e.getStackTrace();
        }
    }

    protected org.jsoup.nodes.Document getDocument() throws IOException {

        return Jsoup.parse(new File(filePath), "UTF-8");



    }
}
