package com.jspider.musicplayerjdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class SongOperations {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static FileReader fileReader;
	private static Properties properties;
	private static ResultSet resultSet;
	private static int result;
	private static String selectSong;
	private static String selectSong1;
	private static String insertSong;
	private static String updateSong;
	private static String deleteSong;
	private static String filePath = "C:\\Users\\Pooja Rupnawar\\eclipse-workspace\\WEJA1\\musicplayerjdbc\\resources\\db_info.properties";
	
	static Scanner scanner = new Scanner(System.in);

	public static void openConnection() {

		try {

			fileReader = new FileReader(filePath);
			properties = new Properties();
			properties.load(fileReader);
			
			Class.forName(properties.getProperty("driverPath"));

			connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void playAllSong() {
		try {
			openConnection();
			
			selectSong = "select * from  spotify";
			
			preparedStatement = connection.prepareStatement(selectSong);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				for (int i = 1; i <= 5; i++) {
					System.out.print(resultSet.getString(i) + " || ");
				}
				System.out.println("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void chooseSongPlay() {

		openConnection();

		playAllSong();
		selectSong1 = "select * from  spotify where Song_Name =?";
		try {
			preparedStatement = connection.prepareStatement(selectSong1);
			System.out.println("Pls Write The Song Name Which Is Mentioned In The Above List");
			preparedStatement.setString(1, scanner.nextLine());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				for (int i = 1; i <= 5; i++) {
					System.out.print(resultSet.getString(i) + " || ");
				}
				System.out.println("");
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	public static void addSong() {

		openConnection();
		playAllSong();
		insertSong = "insert into  spotify values(?,?,?,?,?)";
		try {

			preparedStatement = connection.prepareStatement(insertSong);
			
			System.out.println("pls check the Sr_No from Above List \n Enter Sr_No of Song");
			
			preparedStatement.setInt(1, scanner.nextInt());
			System.out.println("Pls Enter The Song_Name");
			
			preparedStatement.setString(2, scanner.nextLine());
			System.out.println("Pls Enter The Singer Name");
			
			preparedStatement.setString(3, scanner.nextLine());
			System.out.println("Pls Enter Movie Name ");
			
			preparedStatement.setString(4, scanner.nextLine());
			System.out.println("Pls Enter The Song_Duration");
			
			preparedStatement.setString(5, scanner.nextLine());

			result = preparedStatement.executeUpdate();
			System.out.println("Query Ok " + result
					+ "Ros(s) Affected...\n Song Added Successfully.... \n pls Check In Bellow List Song Is Added or Not");
			playAllSong();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void updateSong() {
		openConnection();
		playAllSong();

		System.out
				.println("Pls Check The Sr_No  of Song From Above List Which Is Need To Update \n Enter Sr_No of Song");

	}

	public static void removeSong() {
		
		openConnection();
		playAllSong();

		deleteSong = "delete from  spotify where Sr_No =?";

		try {

			preparedStatement = connection.prepareStatement(deleteSong);
			System.out.println(
					"Pls See The Sr_No of the Song Which is you want to remove it  \n Enter The Sr_No Of Song Which Is Need to Remove It");
			preparedStatement.setInt(1, scanner.nextInt());
			result = preparedStatement.executeUpdate();
			System.out.println("Query Ok " + result
					+ "Ros(s) Affected...\n Song Removed Successfully.... \n Pls Check In Bellow List Song Is Removed or Not");
			playAllSong();

		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

}