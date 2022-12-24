package editor;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextEditor extends JFrame {
    private static String currentFilePath;
    private static final JFileChooser fileChooser = new JFileChooser("C:\\Users\\BotMachine\\IdeaProjects\\Text Editor\\Data\\Text files");
    private static final JCheckBox useRegExCheckbox = new JCheckBox("Use regex");
    private static final JTextField searchTextField = new JTextField();
    private static final JTextArea textArea = new JTextArea();
    private static final Font font = new Font("Font", Font.BOLD, 12);

    static class Searcher {
        private static boolean currentWordIsFined;
        private static Integer currentIndex = 0;
        private final static Map<Integer, String> matchesWords = new HashMap<>();
        private final static List<Integer> indexList = new ArrayList<>();

        private static void setPattern(String str, String text) {
            matchesWords.clear();
            indexList.clear();
            currentIndex = 0;
            currentWordIsFined = false;

            String word1;

            if (!useRegExCheckbox.isSelected()) {
                word1 = convertRegexToWord(str);
            } else {
                word1 = str;
            }

            System.out.println(word1);
            Pattern pattern = Pattern.compile(word1);
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                if (!currentWordIsFined) {
                    currentWordIsFined = true;
                }
                int index = matcher.start();
                String word = matcher.group();
                matchesWords.put(index, word);
                indexList.add(index);
            }

            if (currentWordIsFined) {
                selectWord();
            }
        }

        private static void increaseIndex() {
            currentIndex++;
            selectWord();
        }

        private static void decreaseIndex() {
            currentIndex--;
            selectWord();
        }

        private static void selectWord() {
            textArea.setCaretPosition(indexList.get(currentIndex) + matchesWords.get(indexList.get(currentIndex)).length());
            textArea.select(indexList.get(currentIndex), indexList.get(currentIndex) + matchesWords.get(indexList.get(currentIndex)).length());
            textArea.grabFocus();
        }
    }

    public TextEditor() {
        super("Text Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 800);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        fileChooser.setName("FileChooser");
        add(fileChooser);

        JMenuBar jMenuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.setName("MenuFile");

        JMenuItem openMenuItem = new JMenuItem("Load");
        openMenuItem.setName("MenuOpen");
        openMenuItem.addActionListener(e -> openFile());
        fileMenu.add(openMenuItem);

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.setName("MenuSave");
        saveMenuItem.addActionListener(e -> saveFile());
        fileMenu.add(saveMenuItem);

        fileMenu.addSeparator();

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setName("MenuExit");
        exitMenuItem.addActionListener(e -> {
            dispose();
        });
        fileMenu.add(exitMenuItem);

        jMenuBar.add(fileMenu);

        JMenu searchMenu = new JMenu("Search");
        searchMenu.setName("MenuSearch");

        JMenuItem startSearchMenuItem = new JMenuItem("Start search");
        startSearchMenuItem.setName("MenuStartSearch");
        startSearchMenuItem.addActionListener(e -> startSearch());
        searchMenu.add(startSearchMenuItem);

        JMenuItem previousSearchMenuItem = new JMenuItem("Previous search");
        previousSearchMenuItem.setName("MenuPreviousMatch");
        previousSearchMenuItem.addActionListener(e -> previousMatch());
        searchMenu.add(previousSearchMenuItem);

        JMenuItem nextMatchMenuItem = new JMenuItem("Next match");
        nextMatchMenuItem.setName("MenuNextMatch");
        nextMatchMenuItem.addActionListener(e -> nextMatch());
        searchMenu.add(nextMatchMenuItem);

        JMenuItem useRegularExpressionsMenuItem = new JMenuItem("Use regular expressions");
        useRegularExpressionsMenuItem.setName("MenuUseRegExp");
        useRegularExpressionsMenuItem.addActionListener(e -> {
            useRegExCheckbox.setSelected(!useRegExCheckbox.isSelected());
        });
        searchMenu.add(useRegularExpressionsMenuItem);

        jMenuBar.add(searchMenu);

        setJMenuBar(jMenuBar);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(5, 5));
        Border borderMainPanel = mainPanel.getBorder();
        Border marginMainPanel = new EmptyBorder(5,5,5,5);
        mainPanel.setBorder(new CompoundBorder(borderMainPanel, marginMainPanel));

        JPanel filePanel = new JPanel();
        filePanel.setPreferredSize(new Dimension(600, 30));
        filePanel.setLayout(new BorderLayout());

        JPanel filePanelWest = new JPanel();
        filePanelWest.setPreferredSize(new Dimension(70, 30));
        filePanelWest.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 0));

        JButton openButton = new JButton(new ImageIcon("C:\\Users\\BotMachine\\IdeaProjects\\Text Editor\\Data\\Icons\\loadIconPNG.png"));
        openButton.setPreferredSize(new Dimension(30, 30));
        openButton.setBackground(Color.white);
        openButton.setName("OpenButton");
        setFont(openButton);
        openButton.addActionListener(e -> openFile());
        filePanelWest.add(openButton);

        JButton saveButton = new JButton(new ImageIcon("C:\\Users\\BotMachine\\IdeaProjects\\Text Editor\\Data\\Icons\\saveIconPNG.png"));
        saveButton.setPreferredSize(new Dimension(30, 30));
        saveButton.setBackground(Color.white);
        saveButton.setName("SaveButton");
        setFont(saveButton);
        saveButton.addActionListener(e -> saveFile());
        filePanelWest.add(saveButton);

        filePanel.add(filePanelWest, BorderLayout.WEST);

        searchTextField.setName("SearchField");
        setFont(searchTextField);
        filePanel.add(searchTextField, BorderLayout.CENTER);

        JPanel filePanelEast = new JPanel();
        filePanelEast.setLayout(new FlowLayout(FlowLayout.LEFT,5, 0));

        JButton startSearchButton = new JButton(new ImageIcon("C:\\Users\\BotMachine\\IdeaProjects\\Text Editor\\Data\\Icons\\searchIconPNG.png"));
        startSearchButton.setBackground(Color.white);
        startSearchButton.setPreferredSize(new Dimension(30, 30));
        startSearchButton.setName("StartSearchButton");
        startSearchButton.addActionListener(e -> startSearch());
        filePanelEast.add(startSearchButton);

        JButton previousMatchButton = new JButton(new ImageIcon("C:\\Users\\BotMachine\\IdeaProjects\\Text Editor\\Data\\Icons\\leftIconPNG.png"));
        previousMatchButton.setBackground(Color.white);
        previousMatchButton.setPreferredSize(new Dimension(30, 30));
        previousMatchButton.setName("PreviousMatchButton");
        previousMatchButton.addActionListener(e -> previousMatch());
        filePanelEast.add(previousMatchButton);

        JButton nextMatchButton = new JButton(new ImageIcon("C:\\Users\\BotMachine\\IdeaProjects\\Text Editor\\Data\\Icons\\rightIconPNG.png"));
        nextMatchButton.setBackground(Color.white);
        nextMatchButton.setPreferredSize(new Dimension(30, 30));
        nextMatchButton.setName("NextMatchButton");
        nextMatchButton.addActionListener(e -> nextMatch());
        filePanelEast.add(nextMatchButton);

        setFont(useRegExCheckbox);
        useRegExCheckbox.setName("UseRegExCheckbox");
        filePanelEast.add(useRegExCheckbox);

        filePanel.add(filePanelEast, BorderLayout.EAST);

        mainPanel.add(filePanel, BorderLayout.PAGE_START);

        textArea.setName("TextArea");
        setFont(textArea);

        JScrollPane scrollableTextArea = new JScrollPane(textArea);
        scrollableTextArea.setName("ScrollPane");
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        mainPanel.add(scrollableTextArea, BorderLayout.CENTER);

        add(mainPanel);
    }

    private static void setFont(Component component) {
        component.setFont(font);
        component.setFont(component.getFont().deriveFont(15f));
    }

    private static void openFile() {
        int r = fileChooser.showOpenDialog(null);

        if (r == JFileChooser.APPROVE_OPTION) {
            textArea.setText("");
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            try {
                textArea.read(new FileReader(file), null);
            } catch (IOException ignored) {
            }
        }
    }

    private static void saveFile() {
        int r = fileChooser.showSaveDialog(null);

        if (r == JFileChooser.APPROVE_OPTION) {
            try {
                textArea.write(new FileWriter(fileChooser.getSelectedFile().getAbsolutePath()));
            } catch (IOException ignored) {
            }
        }
    }

    private static void startSearch() {
        Searcher.setPattern(searchTextField.getText(), textArea.getText());
    }

    private static void previousMatch() {
        if (Searcher.currentWordIsFined) {
            if (Searcher.currentIndex - 1 != -1) {
                Searcher.decreaseIndex();
            } else {
                Searcher.currentIndex = Searcher.indexList.size() - 1;
                Searcher.selectWord();
            }
        }
    }

    private static void nextMatch() {
        if (Searcher.currentWordIsFined) {
            if (Searcher.currentIndex + 1 != Searcher.indexList.size()) {
                Searcher.increaseIndex();
            } else {
                Searcher.currentIndex = 0;
                Searcher.selectWord();
            }
        }
    }

    public static String convertRegexToWord(String regex) {
        StringBuilder word = new StringBuilder(regex);
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '.' ||
                    word.charAt(i) == '\\' ||
                    word.charAt(i) == '?' ||
                    word.charAt(i) == ']' ||
                    word.charAt(i) == '[') {
                word.insert(i, '\\');
                i++;
            }
        }
        return word.toString();
    }
}
