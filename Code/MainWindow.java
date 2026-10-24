import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

  public MainWindow() {
      // Set up the main window
      setTitle("GamePlan - Task Manager");
      setSize(800, 500);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);

      // Main Layout
      setLayout(new BorderLayout());

      // Title at the top
      JLabel titleLabel = new JLabel(
          "Welcome to GamePlan!",
          SwingConstants.CENTER
      );
      titleLabel.setFont(new Font("Arial", Font.BOLD, 26));

      add(titleLabel, BorderLayout.NORTH);

      // Area where tasks will appear
      JPanel taskPanel = new JPanel(new BorderLayout());
      taskPanel.setBorder(
          BorderFactory.createTitledBorder("Your Tasks")
      );

      JLabel emptyLabel = new JLabel(
          "No tasks added yet.",
           SwingConstants.CENTER
      );

      taskPanel.add(emptyLabel, BorderLayout.CENTER);
      add(taskPanel, BorderLayout.CENTER);

      // Buttons for future task fuctionality
      JPanel buttonPanel = new JPanel();

      JButton addButton = new JButton("Add Task");
      JButton editButton = new JButton("Edit Task");
      JButton deleteButton = new JButton("Delete Task");

      buttonPanel.add(addButton);
      buttonPanel.add(editButton);
      buttonPanel.add(deleteButton);

      add(buttonPanel, BorderLayout.SOUTH);
  }

  public static void main(String[] args) {
      SwingUtilities.invokeLater(()-> {
          MainWindow window = new MainWindow();
          window.setVisible(true);
      });
  }
}
