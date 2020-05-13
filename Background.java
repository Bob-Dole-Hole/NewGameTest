import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;
public class Background 
{
	private final Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
    private final double stageWidth = screenBounds.getWidth();
    private final double stageHeight = screenBounds.getHeight();
    private final int moveSpeed = 2;
    private double viewportPosX;
    private double viewportPosY;
    private Image bg;
    private ImageView bgImageView;
    private Rectangle2D bgViewport;
    public Background(int viewportPosX, int viewportPosY, Image bg, ImageView bgImageView, Rectangle2D bgViewport)
    {
        this.viewportPosX = viewportPosX;
        this.viewportPosY = viewportPosY;
        this.bg = bg;
        this.bgImageView = bgImageView;
        this.bgViewport = bgViewport;
        bgImageView.setViewport(bgViewport);
    }
    public Background()
    {
        viewportPosX = 0;
        viewportPosY = 0;
        bg = new Image("nebula.jpg");
        bgImageView = new ImageView(bg);
        bgViewport = new Rectangle2D(viewportPosX, viewportPosY, stageWidth, stageHeight);
        bgImageView.setViewport(bgViewport);
    }
    public void updateBackground()
    {
    	if (Game.getInput().contains("W"))
    	{
    		viewportPosY -= moveSpeed;
    		bgViewport = new Rectangle2D(viewportPosX, viewportPosY, stageWidth, stageHeight);
    		bgImageView.setViewport(bgViewport);
    	}
    	if (Game.getInput().contains("A"))
    	{
    		viewportPosX -= moveSpeed;
    		bgViewport = new Rectangle2D(viewportPosX, viewportPosY, stageWidth, stageHeight);
    		bgImageView.setViewport(bgViewport);
    	}
    	if (Game.getInput().contains("S"))
    	{
    		viewportPosY += moveSpeed;
    		bgViewport = new Rectangle2D(viewportPosX, viewportPosY, stageWidth, stageHeight);
    		bgImageView.setViewport(bgViewport);
    	}
    	if (Game.getInput().contains("D"))
    	{
    		viewportPosX += moveSpeed;
    		bgViewport = new Rectangle2D(viewportPosX, viewportPosY, stageWidth, stageHeight);
    		bgImageView.setViewport(bgViewport);
    	}
    }
    public Image getBackground()
    {
        return bg;
    }
    public ImageView getBackgroundImageView()
    {
        return bgImageView;
    }
    public Rectangle2D getBackgroundViewport()
    {
        return bgViewport;
    }
    public double getPosX()
    {
        return this.viewportPosX;
    }
    public double getPosY()
    {
        return viewportPosY;
    }
    public void setBackground(Image bg)
    {
        this.bg = bg;
    }
    public void setBackgroundImageView(ImageView bgImageView)
    {
        this.bgImageView = bgImageView;
    }
    public void setBackgroundViewport(Rectangle2D bgViewport)
    {
        this.bgViewport = bgViewport;
    }
    public void setPosX(int posX)
    {
        this.viewportPosX = posX;
    }
    public void setPosY(int posY)
    {
        this.viewportPosY = posY;
    }
}