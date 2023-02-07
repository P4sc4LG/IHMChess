import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class bishop extends Piece{
	private String couleur;
	private int x;
	private int y;
	private ImageView imageView;
	
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public int getX() {
		return super.x;
	}
	public void setX(int x) {
		super.x = x;
	}

	public int getY() {
		return super.y;
	}
	public void setY(int y) {
		super.y = y;
	}
	public ImageView getImageView() {
		return imageView;
	}
	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}
	public bishop(String couleur ,int x,int y) {
		this.couleur=couleur;
		super.couleur=couleur;
		super.x=x;
		super.y=y;
		Image image= new Image("/pieces/"+this.couleur+"Bishop.png",50,50,false,false);
		this.imageView = new ImageView(image);
		super.setV(this.imageView);
	}
}
