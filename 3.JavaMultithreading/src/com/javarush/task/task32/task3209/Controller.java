package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Created by a.zinov on 07.04.2017.
 */
public class Controller {

    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public void init() {
        createNewDocument();
    }

    public void exit() {
        System.exit(0);
    }

    public static void main(String[] args) {

        View view = new View();
        Controller controller = new Controller(view);

        view.setController(controller);

        view.init();
        controller.init();
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void resetDocument() {
        if (document!= null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }

        HTMLEditorKit kit = new HTMLEditorKit();
        document = (HTMLDocument) kit.createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());

        view.update();
    }

    public void setPlainText(String text) {

        resetDocument();
        StringReader stringReader = new StringReader(text);
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try {
            htmlEditorKit.read(stringReader, document, 0);
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText() {

        StringWriter stringWriter = new StringWriter();
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try {
            htmlEditorKit.write(stringWriter, document, 0, document.getLength());
        }catch (Exception e) {
            ExceptionHandler.log(e);
        }

        return stringWriter.toString();
    }

    public void createNewDocument() {

        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;

    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());

        if (jFileChooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION) {
            currentFile = jFileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            try (FileReader fileReader = new FileReader(currentFile)) {
                htmlEditorKit.read(fileReader, document, 0);
                view.resetUndo();
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }

        }
    }

    public void saveDocument() {

        if (currentFile != null) {
            view.selectHtmlTab();
            view.setTitle(currentFile.getName());
            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            try (FileWriter fileWriter = new FileWriter(currentFile)) {
                htmlEditorKit.write(fileWriter, document, 0, document.getLength());
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }else {
            saveDocumentAs();
        }

    }

    public void saveDocumentAs() {

        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());

        if (jFileChooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {
            currentFile = jFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            try (FileWriter fileWriter = new FileWriter(currentFile)) {
                htmlEditorKit.write(fileWriter, document, 0, document.getLength());
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }

    }
}
