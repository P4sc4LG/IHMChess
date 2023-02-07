import java.awt.Color;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class pion extends Piece {
	public Boolean firstMove=true;
	public String couleur;
	private int x;
	 
	private int y;
	private ImageView imageView;
	public pion(String couleur ,int x,int y) {
		super();
		super.x=x;
		super.y=y;
		super.couleur=couleur;
		this.couleur=couleur;
		this.x=x;
		this.y=y;
		Image image= new Image("/pieces/"+this.couleur+"Pawn.png",50,50,false,false);
		this.imageView = new ImageView(image);
		super.setV(this.imageView);
		
	}
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
		super.x =x;
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
	@Override
	public void afficheCase(List<Piece> lesPieces, GridPane root) {
		if(this.couleur.equals("black")) {
		if((ImageView)getNodeByRowColumnIndex(super.y+1, super.x-1, root)!=null&&!getPieceByImageView((ImageView)getNodeByRowColumnIndex(super.y+1, super.x-1, root)).couleur.equals(this.couleur)){
			((Rectangle) getRectByRowColumnIndex(super.y+1, super.x-1, root)).setFill(javafx.scene.paint.Color.BLUE);
		}
		if((ImageView)getNodeByRowColumnIndex(super.y+1, super.x+1, root)!=null&&!getPieceByImageView((ImageView)getNodeByRowColumnIndex(super.y+1, super.x+1, root)).couleur.equals(this.couleur)){
			((Rectangle) getRectByRowColumnIndex(super.y+1, super.x+1, root)).setFill(javafx.scene.paint.Color.BLUE);
		}
		if((ImageView)getNodeByRowColumnIndex(super.y+1, super.x, root)==null) {
			((Rectangle) getRectByRowColumnIndex(super.y+1, super.x, root)).setFill(javafx.scene.paint.Color.BLUE);
		}
		if((ImageView)getNodeByRowColumnIndex(super.y+2, super.x, root)==null && firstMove) {
			((Rectangle) getRectByRowColumnIndex(super.y+2, super.x, root)).setFill(javafx.scene.paint.Color.BLUE);
		}
		}
		else {
			if((ImageView)getNodeByRowColumnIndex(super.y-1, super.x-1, root)!=null&&!getPieceByImageView((ImageView)getNodeByRowColumnIndex(super.y-1, super.x-1, root)).couleur.equals(this.couleur)){
				((Rectangle) getRectByRowColumnIndex(super.y-1, super.x-1, root)).setFill(javafx.scene.paint.Color.BLUE);
			}
			if((ImageView)getNodeByRowColumnIndex(super.y-1, super.x+1, root)!=null&&!getPieceByImageView((ImageView)getNodeByRowColumnIndex(super.y-1, super.x+1, root)).couleur.equals(this.couleur)){
				((Rectangle) getRectByRowColumnIndex(super.y-1, super.x+1, root)).setFill(javafx.scene.paint.Color.BLUE);
			}
			if((ImageView)getNodeByRowColumnIndex(super.y-1, super.x, root)==null) {
				((Rectangle) getRectByRowColumnIndex(super.y-1, super.x, root)).setFill(javafx.scene.paint.Color.BLUE);
			}
			if((ImageView)getNodeByRowColumnIndex(super.y-2, super.x, root)==null && firstMove) {
				((Rectangle) getRectByRowColumnIndex(super.y-2, super.x, root)).setFill(javafx.scene.paint.Color.BLUE);
			}
			}
		
		}
		
	
    public Node getRectByRowColumnIndex (final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column && node instanceof Rectangle) {
                result = node;
                break;
            }
        }

        return result;
    }
    public Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column && node instanceof ImageView) {
                result = node;
                break;
            }
        }

        return result;
    }
    public Piece getPieceByImageView(ImageView v) {
  	  for (int i = 0;i<App.lesPieces.size();i++) {
  		  if (App.lesPieces.get(i).getV().equals(v)) {
  			  return App.lesPieces.get(i);
  		  }
  	  }
  	  return null;
    }
}
