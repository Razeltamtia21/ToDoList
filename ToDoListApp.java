import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListApp {
    private JFrame frame;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskField;

    public ToDoListApp() {
        frame = new JFrame("To-Do List");
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskField = new JTextField(20);

        JButton addButton = new JButton("Add Task");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText();
                if (!task.isEmpty()) {
                    taskListModel.addElement(task);
                    taskField.setText("");
                }
            }
        });

        JButton removeButton = new JButton("Remove Task");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    taskListModel.remove(selectedIndex);
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Task:"));
        panel.add(taskField);
        panel.add(addButton);
        panel.add(removeButton);

        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoListApp::new);
    }
}
