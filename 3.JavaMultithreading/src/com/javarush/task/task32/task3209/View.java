package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by a.zinov on 07.04.2017.
 */
public class View extends JFrame implements ActionListener {

    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();

    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public View() {

        try {
            String systemLookAndFeel = UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel(systemLookAndFeel);
        }catch (Exception e) {
            ExceptionHandler.log(e);
        }

    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String actionString = actionEvent.getActionCommand();

        switch (actionString) {
            case "Новый" :
                controller.createNewDocument();
                break;
            case "Открыть" :
                controller.openDocument();
                break;
            case "Сохранить" :
                controller.saveDocument();
                break;
            case "Сохранить как..." :
                controller.saveDocumentAs();
                break;
            case "Выход" :
                controller.exit();
                break;
            case "О программе" :
                showAbout();
                break;
        }
    }

    public void init() {

        initGui();

        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);
        setVisible(true);

    }

    public void exit() {
        controller.exit();
    }

    public void initMenuBar() {

        JMenuBar jMenuBar = new JMenuBar();

        MenuHelper.initFileMenu(this, jMenuBar);
        MenuHelper.initEditMenu(this, jMenuBar);
        MenuHelper.initStyleMenu(this, jMenuBar);
        MenuHelper.initAlignMenu(this, jMenuBar);
        MenuHelper.initColorMenu(this, jMenuBar);
        MenuHelper.initFontMenu(this, jMenuBar);
        MenuHelper.initHelpMenu(this, jMenuBar);

        this.getContentPane().add(jMenuBar, BorderLayout.NORTH);

    }

    public void initEditor() {
        htmlTextPane.setContentType("text/html");

        JScrollPane jScrollPaneHTML = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", jScrollPaneHTML);
        JScrollPane jScrollPaneTEXT = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", jScrollPaneTEXT);

        tabbedPane.setPreferredSize(new Dimension(1280, 960));

        TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tabbedPaneChangeListener);

        this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    public void selectedTabChanged() {

        switch (tabbedPane.getSelectedIndex()) {
            case 0 : controller.setPlainText(plainTextPane.getText());
                break;
            case 1 : plainTextPane.setText(controller.getPlainText());
                break;
        }
        resetUndo();
    }

    public boolean canUndo() {
        return undoManager.canUndo();
    }

    public boolean canRedo() {
        return undoManager.canRedo();
    }

    public void undo() {
        try {
            undoManager.undo();
        }catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void redo() {
        try {
            undoManager.redo();
        }catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void resetUndo() {
        undoManager.discardAllEdits();
    }

    public boolean isHtmlTabSelected() {
        if (tabbedPane.getSelectedIndex() == 0) {
            return true;
        }else {
            return false;
        }
    }

    public void selectHtmlTab() {
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update() {
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout() {
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Версия 1.0", "О программе", JOptionPane.INFORMATION_MESSAGE);
    }
}
