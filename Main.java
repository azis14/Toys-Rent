import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.*;
import javafx.scene.shape.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import javafx.scene.control.ScrollBar;
import javafx.geometry.Orientation;
import javafx.beans.value.*;
import javafx.geometry.Insets;

import java.util.ArrayList;

import backend.Kategori;
import backend.Admin;
import backend.Barang;
import backend.Pemesanan;

public class Main extends Application {

    @Override
     public void start(Stage primaryStage) {
        // TODO Buat sesuai permintaan soal

        //--------------------------------------------------------------------------------
     	//HomePage
     	Image image = new Image("src/Toy.png");
     	ImageView iv = new ImageView();
     	iv.setImage(image);

     	iv.setX(200);
     	iv.setY(100);

     	iv.setFitWidth(100);
     	iv.setFitHeight(100);

        Text homeText = new Text(125, 250, "Selamat Datang di Toys Rent, \nIngin Login Sebagai Siapa?");
        homeText.setFont(Font.font("futura", FontWeight.BOLD, 18));

        homeText.setTextAlignment(TextAlignment.CENTER);

        Button btAnggota = new Button("Anggota");
        Button btAdmin = new Button("Admin");

        btAnggota.setLayoutX(150);
        btAnggota.setLayoutY(350);

        btAdmin.setLayoutX(300);
        btAdmin.setLayoutY(350);

        Text copyright = new Text(120, 490, "Copyright \u00A9 Muhammad Azis Husein");
        copyright.setFont(Font.font("monospace", FontWeight.BOLD, 14));

        Pane pane = new Pane();
        pane.getChildren().addAll(btAnggota, btAdmin, homeText, iv, copyright);

        Scene scene = new Scene(pane, 500, 500);

        pane.setStyle("-fx-background-color: lightcyan;");

        primaryStage.setTitle("TOYS RENT APP");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("src/boy.png"));
        primaryStage.setResizable(false);
        primaryStage.show();


        //---------------------------------------------------------------------
        //Event HomePage
        btAdmin.setOnAction((ActionEvent e) -> {
        	this.adminPage(primaryStage);
    	});

    	btAnggota.setOnAction((ActionEvent e) -> {
        	this.anggotaPage(primaryStage);
    	});

    }

    public static void main(String[] args) {
         Application.launch(args);
    }

    public void anggotaPage(Stage primaryStage){
    	//-----------------------------------------------------------------------------------
    	//AnggotaPage
    	Text anggotaText = new Text (75, 25, "Halo Anggota, Apa yang Ingin Anda Lakukan?");
        anggotaText.setFont(Font.font("futura", FontWeight.BOLD, 18));

        anggotaText.setTextAlignment(TextAlignment.CENTER);

        Button btSewa = new Button("Sewa Barang");
        Button btList = new Button("List Penyewaan");
        Button btLogout = new Button("Logout");

        Image image = new Image("src/doraemon.png");
     	ImageView iv = new ImageView();
     	iv.setImage(image);

     	iv.setX(200);
     	iv.setY(150);

     	iv.setFitWidth(300);
     	iv.setFitHeight(300);

        btSewa.setLayoutX(75);
        btSewa.setLayoutY(40);

        btList.setLayoutX(225);
        btList.setLayoutY(40);

        btLogout.setLayoutX(375);
        btLogout.setLayoutY(40);

        Text copyright = new Text(120, 490, "Copyright \u00A9 Muhammad Azis Husein");
        copyright.setFont(Font.font("monospace", FontWeight.BOLD, 14));

        Pane paneAnggota = new Pane();
        paneAnggota.getChildren().addAll(anggotaText, btSewa, btList, btLogout, iv, copyright);

        paneAnggota.setStyle("-fx-background-color: AQUA;");

        Scene sceneAnggota = new Scene(paneAnggota, 500, 500);

        primaryStage.setScene(sceneAnggota);

        btLogout.setOnAction((ActionEvent e) -> {
        	this.start(primaryStage);
    	});

    	btSewa.setOnAction((ActionEvent e) -> {
        	this.sewaPage(primaryStage);
    	});

    	btList.setOnAction((ActionEvent e) -> {
        	this.listSewaPage(primaryStage);
    	});
    }

    public void adminPage(Stage primaryStage){
    	Text adminText = new Text(75, 25, "Halo Admin, Apa yang ingin Anda lakukan?");
        adminText.setFont(Font.font("futura", FontWeight.BOLD, 18));

        adminText.setTextAlignment(TextAlignment.CENTER);

        Button btKategori = new Button("Buat Kategori");
        Button btBarang = new Button("Buat Barang");
        Button btList = new Button("List Pemesanan");
        Button btLogout = new Button("Logout");

        Image image = new Image("src/Nobita_1.png");
     	ImageView iv = new ImageView();
     	iv.setImage(image);

     	iv.setX(150);
     	iv.setY(100);

     	iv.setFitWidth(250);
     	iv.setFitHeight(350);

        btKategori.setLayoutX(30);
        btKategori.setLayoutY(40);

        btBarang.setLayoutX(150);
        btBarang.setLayoutY(40);

        btList.setLayoutX(270);
        btList.setLayoutY(40);

        btLogout.setLayoutX(390);
        btLogout.setLayoutY(40);

        Text copyright = new Text(120, 490, "Copyright \u00A9 Muhammad Azis Husein");
        copyright.setFont(Font.font("monospace", FontWeight.BOLD, 14));

        Pane paneAdmin = new Pane();
        paneAdmin.getChildren().addAll(adminText, btKategori, btBarang, btList, btLogout, copyright, iv);
 
        paneAdmin.setStyle("-fx-background-color: MEDIUMTURQUOISE;");
        
        Scene sceneAdmin = new Scene(paneAdmin, 500, 500);

        primaryStage.setScene(sceneAdmin);

        btKategori.setOnAction((ActionEvent e) -> {
        	this.kategoriPage(primaryStage);
    	});

    	btLogout.setOnAction((ActionEvent e) -> {
        	this.start(primaryStage);
    	});

    	btBarang.setOnAction((ActionEvent e) -> {
        	this.barangPage(primaryStage);
    	});


    	btList.setOnAction((ActionEvent e) -> {
        	this.confirmPage(primaryStage);
    	});

    }

    public void kategoriPage(Stage primaryStage){
    	Text kategoriText = new Text(120, 25, "Isi Kategori yang Ingin Anda Buat");
        kategoriText.setFont(Font.font("futura", FontWeight.BOLD, 18));

        kategoriText.setTextAlignment(TextAlignment.CENTER);

        Text labelField = new Text(130, 65, "Nama: ");

        labelField.setFont(Font.font("futura", 16));


        TextField fieldNamaKategori = new TextField();

        Button btBuatKategori = new Button("Buat Kategori");
        Button btBack = new Button("Back");

        Text message = new Text(100, 150, "");

        message.setFont(Font.font("courier new", 14));

        message.setTextAlignment(TextAlignment.CENTER);

        fieldNamaKategori.setLayoutX(180);
        fieldNamaKategori.setLayoutY(50);

        btBuatKategori.setLayoutX(90);
        btBuatKategori.setLayoutY(100);

        btBack.setLayoutX(360);
        btBack.setLayoutY(100);

        Text copyright = new Text(120, 490, "Copyright \u00A9 Muhammad Azis Husein");
        copyright.setFont(Font.font("monospace", FontWeight.BOLD, 14));

        Pane paneBuatKategori = new Pane();
        paneBuatKategori.getChildren().addAll(kategoriText, fieldNamaKategori, btBuatKategori, btBack, message, labelField, copyright);

        paneBuatKategori.setStyle("-fx-background-color: DEEPSKYBLUE;");

        Scene sceneBuatKategori = new Scene(paneBuatKategori, 500, 500);

        primaryStage.setScene(sceneBuatKategori);

        btBack.setOnAction((ActionEvent e) -> {
        	this.adminPage(primaryStage);
    	});

    	btBuatKategori.setOnAction((ActionEvent e) -> {
    		if(fieldNamaKategori.getText().equals("")){
    			message.setText("Field harus diisi");
    			message.setFill(Color.RED);
    		}
        	else if(Admin.createKategori(fieldNamaKategori.getText())){
        		message.setText("Kategori berhasil ditmbahkan");
        		message.setFill(Color.BLACK);
        	}
        	else{
        		message.setText("Sudah ada kategori dengan nama yang sama");
        		message.setFill(Color.RED);
        	}
    	});
    }

    public void barangPage(Stage primaryStage){
    	Text barangText = new Text(120, 25, "Isi Barang yang Ingin Anda Buat");
    	barangText.setFont(Font.font("futura", FontWeight.BOLD, 18));

    	barangText.setTextAlignment(TextAlignment.CENTER);

    	ComboBox<Kategori> cmbKategori = new ComboBox<Kategori>();

    	for(Kategori kategori : Admin.getListKategori()){
    		cmbKategori.getItems().add(kategori);
    	}

    	TextField fieldNama = new TextField();

    	Button btBarang = new Button("Buat Barang");

    	Button btBack = new Button("Back");

    	Text labelCmb = new Text(125, 65, "Kategori :");
    	Text labelNama = new Text(125, 105, "Nama :");

    	labelCmb.setFont(Font.font("futura", 16));
    	labelNama.setFont(Font.font("futura", 16));

    	cmbKategori.setLayoutX(195);
    	cmbKategori.setLayoutY(50);

    	fieldNama.setLayoutX(195);
    	fieldNama.setLayoutY(90);

    	btBarang.setLayoutX(100);
    	btBarang.setLayoutY(140);

    	btBack.setLayoutX(300);
    	btBack.setLayoutY(140);

    	Text message = new Text(100, 250, "");

        message.setFont(Font.font("courier new", 14));

        message.setTextAlignment(TextAlignment.CENTER);

    	Text copyright = new Text(120, 490, "Copyright \u00A9 Muhammad Azis Husein");
        copyright.setFont(Font.font("monospace", FontWeight.BOLD, 14));

    	Pane paneBarang = new Pane();
    	paneBarang.getChildren().addAll(barangText, cmbKategori, fieldNama, btBarang, btBack, labelCmb, labelNama, copyright, message);

    	paneBarang.setStyle("-fx-background-color: TEAL;");

    	Scene sceneBarang = new Scene(paneBarang, 500, 500);

    	primaryStage.setScene(sceneBarang);

    	btBack.setOnAction((ActionEvent e) -> {
        	this.adminPage(primaryStage);
    	});

    	btBarang.setOnAction((ActionEvent e) -> {
    		if(cmbKategori.getValue() == null){
    			message.setText("Kategori Harus diisi");
        		message.setFill(Color.RED);
    		}
    		else if(fieldNama.getText().equals("")){
    			message.setText("Nama Harus diisi");
        		message.setFill(Color.RED);
    		}
        	else if(Admin.createBarang(cmbKategori.getValue().getNama(), fieldNama.getText())){
        		message.setText("Barang Berhasil Ditambahkan");
        		message.setFill(Color.BLACK);
        	}
        	else{
        		message.setText("Sudah Ada Barang Dengan Nama yang Sama");
        		message.setFill(Color.RED);
        	}
    	});

    }

    public void sewaPage(Stage primaryStage){
    	Text sewaText = new Text(120, 25, "Pilih Barang yang Ingin Anda Sewa");
    	sewaText.setFont(Font.font("futura", FontWeight.BOLD, 18));

    	sewaText.setTextAlignment(TextAlignment.CENTER);

    	ArrayList<ListView<Barang>> listView = new ArrayList<ListView<Barang>>();
    	ArrayList<Text> textList = new ArrayList<Text>();


    	for(Kategori kategori : Admin.getListKategori()){
    		ObservableList<Barang> names = FXCollections.observableArrayList();
    		for(Barang barang : kategori.getNamaBarang()){
    			if(barang.isDisewakan())
    				names.add(barang);
    		}

    		ListView<Barang> list = new ListView<Barang>(names);
    		listView.add(list);

    		Text text = new Text(kategori.getNama());
    		text.setFont(Font.font("futura", FontWeight.BOLD, 14));
    		textList.add(text);
    	}

    	Pane paneSewa = new Pane();

    	int placeX = 10;
    	int placeY = 60;

    	for(ListView<Barang> list : listView){
    		list.setLayoutX(placeX);
    		list.setLayoutY(placeY);
    		placeX += 260;
    		if(placeX == 530){
    			placeY += 420;
    			placeX = 10;
    		}
    		list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    		paneSewa.getChildren().add(list);
    	}

    	Button btBack = new Button("Back");
    	Button btSewa = new Button("Sewa Barang");

    	if(placeX == 10){
    		btSewa.setLayoutX(150);
    		btSewa.setLayoutY(placeY + 50);
    		btBack.setLayoutX(250);
    		btBack.setLayoutY(placeY + 50);
    	}
    	else{	
    		btSewa.setLayoutX(150);
    		btSewa.setLayoutY(placeY + 450);
    		btBack.setLayoutX(250);
    		btBack.setLayoutY(placeY + 450);
    	}

    	placeX = 10;
    	placeY = 52;

    	for(Text text : textList){
    		text.setLayoutX(placeX);
    		text.setLayoutY(placeY);
    		placeX += 260;
    		if(placeX == 530){
    			placeY += 420;
    			placeX = 10;
    		}
    		paneSewa.getChildren().add(text);
    	}


    	ScrollBar sc = new ScrollBar();

    	sc.setLayoutX(535);
    	sc.setLayoutY(5);
        sc.setMin(0);
        sc.setOrientation(Orientation.VERTICAL);
        sc.setPrefHeight(placeY + 600);
        sc.setMax(placeY + 300);

    	paneSewa.setStyle("-fx-background-color: CHARTREUSE;");
    	

    	paneSewa.getChildren().addAll(sewaText, sc, btBack, btSewa);

    	Scene sceneSewa = new Scene(paneSewa, 550, 550);
    	sceneSewa.setFill(Color.CHARTREUSE);


    	primaryStage.setScene(sceneSewa);

    	sc.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                    Number old_val, Number new_val) {
                paneSewa.setLayoutY(-new_val.doubleValue());
            }
        });

        btBack.setOnAction((ActionEvent e) -> {
        	this.anggotaPage(primaryStage);
    	});

    	btSewa.setOnAction((ActionEvent e) -> {

    		for(ListView<Barang> list : listView){
    			ObservableList<Barang> listBarang = list.getSelectionModel().getSelectedItems();
    			for(Barang barang : listBarang){
    				barang.changeStatusMenunggu();
    			}
    		}
        	this.sewaPage(primaryStage);
    	});
    }

    public void confirmPage(Stage primaryStage){
    	Text confirmText = new Text(20, 25, "Konfirmasi Barang-Barang yang Akan Disewakan");
    	confirmText.setFont(Font.font("futura", FontWeight.BOLD, 18));

    	confirmText.setTextAlignment(TextAlignment.CENTER);

    	Text kategoriText = new Text(20, 50, "Kategori");
    	kategoriText.setFont(Font.font("futura", FontWeight.BOLD, 14));

    	Text barangText = new Text(135, 50, "Barang");
    	barangText.setFont(Font.font("futura", FontWeight.BOLD, 14));

    	Text setujuText = new Text(280, 50, "Setuju");
    	setujuText.setFont(Font.font("futura", FontWeight.BOLD, 14));

    	Text tolakText = new Text(380, 50, "Tolak");
    	tolakText.setFont(Font.font("futura", FontWeight.BOLD, 14));

    	ArrayList<Text> listTextBarang = new ArrayList<Text>();
    	ArrayList<Text> listTextKategori = new ArrayList<Text>();
    	ArrayList<Barang> listBarang = new ArrayList<Barang>();
    	ArrayList<Button> listSetuju = new ArrayList<Button>();
    	ArrayList<Button> listTolak = new ArrayList<Button>();

    	for(Barang barang : Admin.getPendingBarang()){
    		listTextBarang.add(new Text(barang.getNama()));
    		listTextKategori.add(new Text(barang.getNamaKategori()));
    		listBarang.add(barang);
    		listSetuju.add(new Button("Setuju"));
    		listTolak.add(new Button("Tolak"));
    	}

    	Pane confirmPane = new Pane();
    	confirmPane.getChildren().addAll(confirmText, kategoriText, barangText, setujuText, tolakText);

    	int placeY1 = 80;
    	int placeY2 = 70;

    	if(listBarang != null){
    		for(int i = 0; i < listBarang.size(); i++){
    			listTextKategori.get(i).setLayoutX(20);
    			listTextKategori.get(i).setLayoutY(placeY1);

    			listTextBarang.get(i).setLayoutX(135);
    			listTextBarang.get(i).setLayoutY(placeY1);

    			listSetuju.get(i).setLayoutX(280);
    			listSetuju.get(i).setLayoutY(placeY2);

    			listTolak.get(i).setLayoutX(380);
    			listTolak.get(i).setLayoutY(placeY2);

    			placeY1 += 50;
    			placeY2 += 50;

    			confirmPane.getChildren().addAll(listTextKategori.get(i), listTextBarang.get(i), listSetuju.get(i), listTolak.get(i));

    			Barang barang = listBarang.get(i);

    			listSetuju.get(i).setOnAction((ActionEvent e) -> {
    				barang.changeStatusDipinjam();
    				new Pemesanan(barang, "Disetujui");
        			this.confirmPage(primaryStage);
    			});

    			listTolak.get(i).setOnAction((ActionEvent e) -> {
    				barang.changeStatusDisewakan();
    				new Pemesanan(barang, "Ditolak");
        			this.confirmPage(primaryStage);
    			});
    		}
    	}

    	Button btBack = new Button("Back");

    	btBack.setLayoutX(150);
    	btBack.setLayoutY(placeY1 + 50);

    	ScrollBar sc = new ScrollBar();

    	sc.setLayoutX(485);
    	sc.setLayoutY(5);
        sc.setMin(0);
        sc.setOrientation(Orientation.VERTICAL);
        sc.setPrefHeight(placeY1 + 400);
        sc.setMax(placeY1 + 200);

        confirmPane.getChildren().addAll(sc, btBack);

        sc.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                    Number old_val, Number new_val) {
                confirmPane.setLayoutY(-new_val.doubleValue());
            }
        });

        btBack.setOnAction((ActionEvent e) -> {
        	this.adminPage(primaryStage);
    	});

    	Scene confirmScene = new Scene(confirmPane, 500, 500);

    	confirmPane.setStyle("-fx-background-color: HOTPINK;");
    	confirmScene.setFill(Color.HOTPINK);

    	primaryStage.setScene(confirmScene);
    }

    public void listSewaPage(Stage primaryStage){
    	Text listText = new Text(20, 25, "List Penyewaan");
    	listText.setFont(Font.font("futura", FontWeight.BOLD, 18));

    	listText.setTextAlignment(TextAlignment.CENTER);

    	Text kategoriText = new Text(20, 50, "Kategori");
    	kategoriText.setFont(Font.font("futura", FontWeight.BOLD, 14));

    	Text barangText = new Text(180, 50, "Barang");
    	barangText.setFont(Font.font("futura", FontWeight.BOLD, 14));

    	Text statusText = new Text(325, 50, "Status");
    	statusText.setFont(Font.font("futura", FontWeight.BOLD, 14));

    	ArrayList<Text> listTextKategori = new ArrayList<Text>();
    	ArrayList<Text> listTextBarang = new ArrayList<Text>();
    	ArrayList<Text> listTextStatus = new ArrayList<Text>();

    	int placeY = 80;

    	for(Pemesanan pemesanan : Pemesanan.getListPemesanan()){
			listTextStatus.add(new Text(325, placeY, pemesanan.getStatus()));
			listTextKategori.add(new Text(20, placeY, pemesanan.getBarang().getNamaKategori()));
			listTextBarang.add(new Text(180, placeY, pemesanan.getBarang().getNama()));

    		placeY += 30;
    	}

    	Pane listSewaPane = new Pane();

    	if(listTextBarang != null){
    		for(int i = 0; i < listTextBarang.size(); i++){
    			listSewaPane.getChildren().addAll(listTextKategori.get(i), listTextBarang.get(i), listTextStatus.get(i));
    		}
    	}

    	Button btBack = new Button("Back");

    	btBack.setLayoutX(150);
    	btBack.setLayoutY(placeY + 50);

    	ScrollBar sc = new ScrollBar();

    	sc.setLayoutX(485);
    	sc.setLayoutY(5);
        sc.setMin(0);
        sc.setOrientation(Orientation.VERTICAL);
        sc.setPrefHeight(placeY + 400);
        sc.setMax(placeY + 200);

        listSewaPane.getChildren().addAll(sc, btBack, listText, kategoriText, barangText, statusText);

        sc.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                    Number old_val, Number new_val) {
                listSewaPane.setLayoutY(-new_val.doubleValue());
            }
        });

        btBack.setOnAction((ActionEvent e) -> {
        	this.anggotaPage(primaryStage);
    	});

    	Scene listSewaScene = new Scene(listSewaPane, 500, 500);
    	
    	listSewaPane.setStyle("-fx-background-color: HONEYDEW;");
    	listSewaScene.setFill(Color.HONEYDEW);

    	primaryStage.setScene(listSewaScene);
    }
 }