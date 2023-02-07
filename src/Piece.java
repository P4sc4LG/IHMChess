import java.util.List;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Piece {
	
	private ImageView v;
	public int x;
	public int y;
	public String couleur;
	public Piece() {
		
		
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setV(ImageView v) {
		this.v = v;
	}
	public ImageView getImageView() {
		
		return v;
	}
	
	public  void afficheCase(List<Piece> lesPieces, GridPane root) {
	}

	public ImageView getV() {
		return v;
	
	}
	

}
