package lk.ijse.dep11;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.*;

public class MainViewController {
    public ListView<String> lvTasks;
    public ListView<String> lvCompletedTasks;
    public TextField txtTask;

    // Source = Drag Detected
    // Target = Drag Over + Drag Drop

    public void txtTaskOnAction(ActionEvent actionEvent) {
        String task = txtTask.getText().strip();
        if (task.isBlank()) {
            txtTask.requestFocus();
            txtTask.selectAll();
            return;
        }

        ObservableList<String> taskList = lvTasks.getItems();
        if (taskList.contains(task)) {
            new Alert(Alert.AlertType.ERROR, "Task already exists").show();
            txtTask.requestFocus();
            txtTask.selectAll();
            return;
        }

        taskList.add(task);
        txtTask.clear();
    }

    public void lvTasksOnDragDetected(MouseEvent e) {
        /* Hey! I want to drag and drop something
         * Great! What do you want to drag? */
        Dragboard dragboard = lvTasks.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent cp = new ClipboardContent();
        cp.putString(lvTasks.getSelectionModel().getSelectedItem());
        dragboard.setContent(cp);
    }

    public void lvCompletedTasksOnDragOver(DragEvent e) {
        e.acceptTransferModes(TransferMode.ANY);
    }

    public void lvCompletedTasksOnDragDropped(DragEvent e) {
        String completedTask = e.getDragboard().getString();
        lvCompletedTasks.getItems().add(completedTask);
        lvTasks.getItems().remove(completedTask);
    }
}
