package vue;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.google.zxing.client.j2se.MatrixToImageWriter;
import model.Bien;





public class CodeQR extends JFrame {
	CodeQR(ArrayList<Bien> listBiens,int index) throws WriterException {
		listBiens = listBiens;

		String data = listBiens.get(index).genererCode();
		int size = 400;

		// encode

		BitMatrix bitMatrix = generateMatrix(data, size);
		BufferedImage Buffimg = MatrixToImageWriter.toBufferedImage(bitMatrix);


		getContentPane().add(new JLabel(new ImageIcon(Buffimg)));


		JButton buttretour = new  JButton("Retour");
		ArrayList<Bien> finalListBiens = listBiens;
		buttretour.addActionListener(actionEvent -> {
			setVisible(false);
			new DashBoard(finalListBiens).setVisible(true);
		});

		JPanel toolpane = new JPanel();
		toolpane.add(buttretour);
		add(toolpane,BorderLayout.SOUTH);

		setSize(800,500);//400 width and 500 height

		pack();
		setVisible(true);
	}


	private static BitMatrix generateMatrix(String data, int size) throws WriterException {
		BitMatrix bitMatrix = new QRCodeWriter().encode(data, BarcodeFormat.QR_CODE, size, size);
		return bitMatrix;
	}
}
