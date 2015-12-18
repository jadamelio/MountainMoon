import javax.swing.JFrame;
import java.awt.Graphics;

public class BasicEx extends JFrame {
	public BasicEx() {
		initUI();
	}

	public BasicEx(int x, int y, mapGraphic a) {
		initUI(x, y, a);
	}

	private void initUI() {
		add(new mapGraphic());
		setTitle("Title");
		//setSize(300, 300);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initUI(int x, int y, mapGraphic a) {
		
		
		add(a);
		setTitle("Title");
		setSize(x, y);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
