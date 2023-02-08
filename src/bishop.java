import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
    public  void afficheCase(List<Piece> lesPieces, GridPane root) {
    	boolean piece;
    	piece=false;
    	int count =0 ;
		for (int i = super.y-1;i>=0;i--) {
			if(!piece) {
			
					if(super.x-1-count>=0&&((ImageView)getNodeByRowColumnIndex(i, super.x-1-count, root)==null) ){
						((Rectangle )getRectByRowColumnIndex(i, super.x-1-count, root)).setFill(Color.DARKBLUE);
					}else {
						piece=true;
						if(super.x-1-count>=0&&getPieceByImageView((ImageView) getNodeByRowColumnIndex(i, super.x-1-count, root)).couleur!=this.couleur) {
						((Rectangle )getRectByRowColumnIndex(i, super.x-1-count, root)).setFill(Color.DARKBLUE);
						}
					}
		
		}
			count++;
	}
		
		piece=false;
		count =0 ;
		for (int i = super.y-1;i>=0;i--) {
			if(!piece) {
			
					if(super.x+1+count<=7&&((ImageView)getNodeByRowColumnIndex(i, super.x+1+count, root)==null) ){
						((Rectangle )getRectByRowColumnIndex(i, super.x+1+count, root)).setFill(Color.DARKBLUE);
					}else {
						piece=true;
						if(super.x+1+count<=7&&getPieceByImageView((ImageView) getNodeByRowColumnIndex(i, super.x+1+count, root)).couleur!=this.couleur) {
						((Rectangle )getRectByRowColumnIndex(i, super.x+1+count, root)).setFill(Color.DARKBLUE);
						}
					}
		
		}
			count++;
	}
		piece=false;
		count=0;
		
		for (int i = super.y+1;i<=7;i++) {
			if(!piece) {
			
					if(super.x-1-count>=0&&((ImageView)getNodeByRowColumnIndex(i, super.x-1-count, root)==null) ){
						((Rectangle )getRectByRowColumnIndex(i, super.x-1-count, root)).setFill(Color.DARKBLUE);
					}else {
						piece=true;
						if(super.x-1-count>=0&&getPieceByImageView((ImageView) getNodeByRowColumnIndex(i, super.x-1-count, root)).couleur!=this.couleur) {
						((Rectangle )getRectByRowColumnIndex(i, super.x-1-count, root)).setFill(Color.DARKBLUE);
						}
					}
		
		}
			count++;
	}
		
		piece=false;
		count =0 ;
		for (int i = super.y+1;i<=7;i++) {
			if(!piece) {
			
					if(super.x+1+count<=7&&((ImageView)getNodeByRowColumnIndex(i, super.x+1+count, root)==null) ){
						((Rectangle )getRectByRowColumnIndex(i, super.x+1+count, root)).setFill(Color.DARKBLUE);
					}else {
						piece=true;
						if(super.x+1+count<=7&&getPieceByImageView((ImageView) getNodeByRowColumnIndex(i, super.x+1+count, root)).couleur!=this.couleur) {
						((Rectangle )getRectByRowColumnIndex(i, super.x+1+count, root)).setFill(Color.DARKBLUE);
						}
					}
		
		}
			count++;
	}
		
		
    }

		//comment
    	
}
