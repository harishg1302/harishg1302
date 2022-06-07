import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;

public class Application1 extends Application {

    int noOfItem1 = 0;
    int noOfItem2 = 0;
    int noOfItem3 = 0;
    int noOfItem4 = 0;

    int priceItem1 = 500;
    int priceItem2 = 200;
    int priceItem3 = 250;
    int priceItem4 = 150;

    String item1 = "Apple Mobile";
    String item2 = "Apple Ipod ";
    String item3 = "Apple SmartWatch ";
    String item4 = "Apple EarPod";

    @Override
    public void start(Stage stage) {
        //Creating Label1
        Label label1 = new Label("    " + item1 + " (500 $)      ");
        label1.contains(20, 20);
        Spinner<Integer> spinnerOne = new Spinner<Integer>(0, 20, 0);

        //Creating Label2
        Label label2 = new Label("    " + item2 + "   (200 $)        ");
        label2.contains(200, 20);
        Spinner<Integer> spinner2 = new Spinner<Integer>(0, 20, 0);

        //Creating Label3
        Label label3 = new Label("    " + item3 + "   (250 $)   ");
        label3.contains(300, 20);
        Spinner<Integer> spinner3 = new Spinner<Integer>(0, 20, 0);


        //Creating Label4
        Label label4 = new Label("   " + item4 + "  (150 $)        ");
        label4.contains(500, 20);
        Spinner<Integer> spinner4 = new Spinner<Integer>(0, 20, 0);

        Button orderItems = new Button("Order Item");
        //Creating a Flow Pane
        FlowPane flowPane = new FlowPane();

        //Setting the horizontal gap between the nodes
        flowPane.setHgap(25);

        //Setting the margin of the pane
        flowPane.setMargin(spinnerOne, new Insets(20, 0, 20, 20));

        //Retrieving the observable list of the flow Pane
        ObservableList list = flowPane.getChildren();

        //Adding all the nodes to the flow pane
        list.addAll(label1, label2, label3, label4, spinnerOne, spinner2, spinner3, spinner4, orderItems);

        orderItems.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                noOfItem1 = (int) spinnerOne.getValue();
                noOfItem2 = (int) spinner2.getValue();
                noOfItem3 = (int) spinner3.getValue();
                noOfItem4 = (int) spinner4.getValue();
                GridPane secondaryLayout = new GridPane();
                secondaryLayout.setHgap(2);
                secondaryLayout.setVgap(2);

                if (noOfItem1 != 0) {
                    Label num_of_itm1 = new Label(String.valueOf(noOfItem1) + "x " + item1 + "  $" + noOfItem1 * priceItem1);
                    num_of_itm1.setFont(new Font("Arial", 15));
                    secondaryLayout.add(num_of_itm1, 2, 5);
                }
                if (noOfItem2 != 0) {
                    Label num_of_itm2 = new Label(String.valueOf(noOfItem2) + "x " + item2 + "   $" + noOfItem2 * priceItem2);
                    num_of_itm2.setFont(new Font("Arial", 15));
                    secondaryLayout.add(num_of_itm2, 2, 10);
                }
                if (noOfItem3 != 0) {
                    Label num_of_itm3 = new Label(String.valueOf(noOfItem3) + "x  " + item3 + "   $" + noOfItem3 * priceItem3);
                    num_of_itm3.setFont(new Font("Arial", 15));
                    secondaryLayout.add(num_of_itm3, 2, 15);
                }
                if (noOfItem4 != 0) {
                    Label num_of_spl = new Label(String.valueOf(noOfItem4) + "x " + item4 + "      $" + noOfItem4 * priceItem4);
                    num_of_spl.setFont(new Font("Arial", 15));
                    secondaryLayout.add(num_of_spl, 2, 20);
                }
                if (noOfItem4 == 0 && noOfItem3 == 0 && noOfItem2 == 0 && noOfItem1 == 0) {
                    Label display = new Label("No Items in the cart");
                    display.setFont(new Font("Arial", 20));
                    secondaryLayout.add(display, 2, 25);
                } else {
                    Label total = new Label("Total :                    $" + ((noOfItem1 * priceItem1) + (noOfItem2 * priceItem2) + (noOfItem3 * priceItem3) + (noOfItem4 * priceItem4)));
                    total.setFont(new Font("Arial", 20));
                    secondaryLayout.add(total, 2, 25);
                }


                Scene secondScene = new Scene(secondaryLayout, 300, 300);

                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Order Summary");
                newWindow.setScene(secondScene);
                showImage(newWindow);

                // Set position of second window, related to primary window.
                newWindow.setX(stage.getX() + 400);
                newWindow.setY(stage.getY() + 400);
                newWindow.show();
            }
        });

        //Creating a scene object
        Scene scene = new Scene(flowPane, 800, 400);

        //Setting title to the Stage
        stage.setTitle("Online Shopping");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }

    private void showImage(Stage stage) {

        try {
            InputStream stream = new FileInputStream("C:\\IBM\\AppleIcon.png");
            Image image = new Image(stream);
            //Creating the image view
            ImageView imageView = new ImageView();
            //Setting image to the image view
            imageView.setImage(image);
            //Setting the image view parameters
            imageView.setX(10);
            imageView.setY(10);
            imageView.setFitWidth(50);
            imageView.setPreserveRatio(true);
            //Setting the Scene object
            Group root = new Group(imageView);
            Scene scene = new Scene(root, 40, 50);
            stage.setTitle("Displaying Image");
//            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String args[]) {
        launch(args);
    }
}

