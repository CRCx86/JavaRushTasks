package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 03.06.2017.
 */
public class MoikrugStrategy implements Strategy {

    //private static final String URL_FORMAT = "http://javarush.ru/testdata/big28data2.html";
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) throws IOException {

        List<Vacancy> vacancies = new ArrayList<>();

        try {
            int pageNumber = 0;
            Document document;
            while (true) {

                document = getDocument(searchString, pageNumber++);
                if (document == null) break;

                //Elements elements = document.select("[data-qa=vacancy-serp__vacancy]");

                Elements elements = document.getElementsByClass("job");
                if (elements.size() == 0) break;

                for (Element element : elements) {

                    String title = element.getElementsByAttributeValue("class", "title").text();
                    Element salaryElement = element.getElementsByAttributeValue("class", "salary").first();
                    String salary  = (salaryElement != null ? salaryElement.text() : "");
                    String url = "https://moikrug.ru" + element.select("a[class=job_icon]").attr("href");
                    Element cityElement = element.getElementsByAttributeValue("class", "location").first();
                    String city = (cityElement != null ? cityElement.text() : "");
                    String companyName = element.getElementsByAttributeValue("class", "company_name").text();


//                    Element titleElement = element.select("[data-qa=vacancy-serp__vacancy-title]").first();
//                    String title = titleElement.text();
//
//                    Element salaryElement = element.select("[data-qa=vacancy-serp__vacancy-compensation]").first();
//                    String salary  = (salaryElement != null ? salaryElement.text() : "");
//
//                    String city = element.select("[data-qa=vacancy-serp__vacancy-address]").first().text();
//
//                    String companyName = element.select("[data-qa=vacancy-serp__vacancy-employer]").first().text();
//
//                    String siteName = "http://hh.ru/";
//
//                    String url = titleElement.attr("href");

                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(title);
                    vacancy.setCity(city);
                    vacancy.setCompanyName(companyName);
                    vacancy.setSalary(salary);
                    vacancy.setSiteName("http://moikrug.ru/");
                    vacancy.setUrl(url);
                    vacancies.add(vacancy);

                }
            }
        }catch (Exception e) {

        }

        return vacancies;

    }

    protected Document getDocument(String searchString, int page) throws IOException {

        String url = String.format(URL_FORMAT, searchString, page);

        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36")
                //.userAgent("Chrome/58.0.3029.110")
                //.timeout(5000)
                .referrer("http://google.ru")
                .get();

        return doc;
    }
}
