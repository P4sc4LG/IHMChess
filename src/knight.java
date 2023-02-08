import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class knight extends Piece{
	
	private String couleur;
	private int x;
	private int y;
	private ImageView imageView;
	public knight(String couleur ,int x,int y) {
		this.couleur=couleur;
		super.couleur=couleur;
		super.x=x;
		super.y=y;
		Image image= new Image("/pieces/"+this.couleur+"Knight.png",50,50,false,false);
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
	


	public void afficheCase(List<Piece> lesPieces, GridPane root) {
		if(super.y-2>=0&&super.x-1>=0) {
			if((ImageView)getNodeByRowColumnIndex(super.y-2, super.x-1, root)!=null) {
				if(!getPieceByImageView((ImageView)getNodeByRowColumnIndex(super.y-2, super.x-1, root)).couleur.equals(this.couleur)) {
					((Rectangle) getRectByRowColumnIndex(super.y-2, super.x-1, root)).setFill(javafx.scene.paint.Color.DARKBLUE);
				}
			}else {((Rectangle) getRectByRowColumnIndex(super.y-2, super.x-1, root)).setFill(javafx.scene.paint.Color.DARKBLUE);}
		}
		if(super.y-2>=0&&super.x+1<=7) {
			if((ImageView)getNodeByRowColumnIndex(super.y-2, super.x+1, root)!=null) {
				if(!getPieceByImageView((ImageView)getNodeByRowColumnIndex(super.y-2, super.x+1, root)).couleur.equals(this.couleur)) {
					((Rectangle) getRectByRowColumnIndex(super.y-2, super.x+1, root)).setFill(javafx.scene.paint.Color.DARKBLUE);
				}
			}else {((Rectangle) getRectByRowColumnIndex(super.y-2, super.x+1, root)).setFill(javafx.scene.paint.Color.DARKBLUE);}
		}
		if(super.y-1>=0&&super.x+2<=7) {
			if((ImageView)getNodeByRowColumnIndex(super.y-1, super.x+2, root)!=null) {
				if(!getPieceByImageView((ImageView)getNodeByRowColumnIndex(super.y-1, super.x+2, root)).couleur.equals(this.couleur)) {
					((Rectangle) getRectByRowColumnIndex(super.y-1, super.x+2, root)).setFill(javafx.scene.paint.Color.DARKBLUE);
				}
			}else {((Rectangle) getRectByRowColumnIndex(super.y-1, super.x+2, root)).setFill(javafx.scene.paint.Color.DARKBLUE);}
		}
		if(super.y-1>=0&&super.x-2>=0) {
			if((ImageView)getNodeByRowColumnIndex(super.y-1, super.x-2, root)!=null) {
				if(!getPieceByImageView((ImageView)getNodeByRowColumnIndex(super.y-1, super.x-2, root)).couleur.equals(this.couleur)) {
					((Rectangle) getRectByRowColumnIndex(super.y-1, super.x-2, root)).setFill(javafx.scene.paint.Color.DARKBLUE);
				}
			}else {((Rectangle) getRectByRowColumnIndex(super.y-1, super.x-2, root)).setFill(javafx.scene.paint.Color.DARKBLUE);}
		}
		if(super.y+1<=7&&super.x-2>=0) {
			if((ImageView)getNodeByRowColumnIndex(super.y+1, super.x-2, root)!=null) {
				if(!getPieceByImageView((ImageView)getNodeByRowColumnIndex(super.y+1, super.x-2, root)).couleur.equals(this.couleur)) {
					((Rectangle) getRectByRowColumnIndex(super.y+1, super.x-2, root)).setFill(javafx.scene.paint.Color.DARKBLUE);
				}
			}else {((Rectangle) getRectByRowColumnIndex(super.y+1, super.x-2, root)).setFill(javafx.scene.paint.Color.DARKBLUE);}
		}
		if(super.y+1<=7&&super.x+2<=7) {
			if((ImageView)getNodeByRowColumnIndex(super.y+1, super.x+2, root)!=null) {
				if(!getPieceByImageView((ImageView)getNodeByRowColumnIndex(super.y+1, super.x+2, root)).couleur.equals(this.couleur)) {
					((Rectangle) getRectByRowColumnIndex(super.y+1, super.x+2, root)).setFill(javafx.scene.paint.Color.DARKBLUE);
				}
			}else {((Rectangle) getRectByRowColumnIndex(super.y+1, super.x+2, root)).setFill(javafx.scene.paint.Color.DARKBLUE);}
		}
		if(super.y+2<=7&&super.x-1>=0) {
			if((ImageView)getNodeByRowColumnIndex(super.y+2, super.x-1, root)!=null) {
				if(!getPieceByImageView((ImageView)getNodeByRowColumnIndex(super.y+2, super.x-1, root)).couleur.equals(this.couleur)) {
					((Rectangle) getRectByRowColumnIndex(super.y+2, super.x-1, root)).setFill(javafx.scene.paint.Color.DARKBLUE);
				}
			}else {((Rectangle) getRectByRowColumnIndex(super.y+2, super.x-1, root)).setFill(javafx.scene.paint.Color.DARKBLUE);}
		}
		if(super.y+2<=7&&super.x+1<=7) {
			if((ImageView)getNodeByRowColumnIndex(super.y+2, super.x+1, root)!=null) {
				if(!getPieceByImageView((ImageView)getNodeByRowColumnIndex(super.y+2, super.x+1, root)).couleur.equals(this.couleur)) {
					((Rectangle) getRectByRowColumnIndex(super.y+2, super.x+1, root)).setFill(javafx.scene.paint.Color.DARKBLUE);
				}
			}else {((Rectangle) getRectByRowColumnIndex(super.y+2, super.x+1, root)).setFill(javafx.scene.paint.Color.DARKBLUE);}
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
