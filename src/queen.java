import javafx.scene.image.Image;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.ImageView;

public class queen extends Piece {
	
	private String couleur;
	private int x;
	private int y;
	private ImageView imageView;
	public queen(String couleur ,int x,int y) {
		this.couleur=couleur;
		super.couleur=couleur;
		super.x=x;
		super.y=y;
		Image image= new Image("/pieces/"+this.couleur+"Queen.png",50,50,false,false);
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
	public  void afficheCase(List<Piece> lesPieces, GridPane root) {
    	boolean piece;
    	piece=false;
    	int count =0 ;
		for (int i = super.y-1;i>=0;i--) {
			if(!piece) {

					if(super.x-1-count>=0&&((ImageView)getNodeByRowColumnIndex(i, super.x-1-count, root)==null) ){
						((Rectangle )getRectByRowColumnIndex(i, super.x-1-count, root)).setFill(Color.BLUE);
					}else {
						piece=true;
						if(super.x-1-count>=0&&getPieceByImageView((ImageView) getNodeByRowColumnIndex(i, super.x-1-count, root)).couleur!=this.couleur) {
						((Rectangle )getRectByRowColumnIndex(i, super.x-1-count, root)).setFill(Color.BLUE);
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
						((Rectangle )getRectByRowColumnIndex(i, super.x+1+count, root)).setFill(Color.BLUE);
					}else {
						piece=true;
						if(super.x+1+count<=7&&getPieceByImageView((ImageView) getNodeByRowColumnIndex(i, super.x+1+count, root)).couleur!=this.couleur) {
						((Rectangle )getRectByRowColumnIndex(i, super.x+1+count, root)).setFill(Color.BLUE);
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
						((Rectangle )getRectByRowColumnIndex(i, super.x-1-count, root)).setFill(Color.BLUE);
					}else {
						piece=true;
						if(super.x-1-count>=0&&getPieceByImageView((ImageView) getNodeByRowColumnIndex(i, super.x-1-count, root)).couleur!=this.couleur) {
						((Rectangle )getRectByRowColumnIndex(i, super.x-1-count, root)).setFill(Color.BLUE);
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
						((Rectangle )getRectByRowColumnIndex(i, super.x+1+count, root)).setFill(Color.BLUE);
					}else {
						piece=true;
						if(super.x+1+count<=7&&getPieceByImageView((ImageView) getNodeByRowColumnIndex(i, super.x+1+count, root)).couleur!=this.couleur) {
						((Rectangle )getRectByRowColumnIndex(i, super.x+1+count, root)).setFill(Color.BLUE);
						}
					}

		}
			count++;
	}	
	 piece=false;
		for (int i = super.x+1;i<=7;i++) {
			if(!piece) {
				if(((ImageView)getNodeByRowColumnIndex(super.y, i, root)==null)){
					((Rectangle )getRectByRowColumnIndex(super.y, i, root)).setFill(Color.BLUE);
				}else {
					piece=true;
					if(getPieceByImageView((ImageView) getNodeByRowColumnIndex(super.y, i, root)).couleur!=this.couleur) {
						((Rectangle )getRectByRowColumnIndex(super.y, i, root)).setFill(Color.BLUE);
					}
				}
			}
		}
		piece=false;
		for (int i = super.x-1;i>=0;i--) {
			if(!piece) {
				if(((ImageView)getNodeByRowColumnIndex(super.y, i, root)==null)){
					((Rectangle )getRectByRowColumnIndex(super.y, i, root)).setFill(Color.BLUE);
				}else {
					piece=true;
					if(getPieceByImageView((ImageView) getNodeByRowColumnIndex(super.y, i, root)).couleur!=this.couleur) {
						((Rectangle )getRectByRowColumnIndex(super.y, i, root)).setFill(Color.BLUE);
					}
				}
			}
		}
		piece=false;
		for (int i = super.y-1;i>=0;i--) {
			if(!piece) {
				if(((ImageView)getNodeByRowColumnIndex(i, super.x, root)==null)){
					((Rectangle )getRectByRowColumnIndex(i, super.x, root)).setFill(Color.BLUE);
				}else {
					piece=true;
					if(getPieceByImageView((ImageView) getNodeByRowColumnIndex(i, super.x, root)).couleur!=this.couleur) {
						((Rectangle )getRectByRowColumnIndex(i, super.x, root)).setFill(Color.BLUE);
					}
				}
			}
		}
		piece=false;
		for (int i = super.y+1;i<=7;i++) {
			if(!piece) {
				if(((ImageView)getNodeByRowColumnIndex(i, super.x, root)==null)){
					((Rectangle )getRectByRowColumnIndex(i, super.x, root)).setFill(Color.BLUE);
				}else {
					piece=true;
					if(getPieceByImageView((ImageView) getNodeByRowColumnIndex(i, super.x, root)).couleur!=this.couleur) {
						((Rectangle )getRectByRowColumnIndex(i, super.x, root)).setFill(Color.BLUE);
					}
				}
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