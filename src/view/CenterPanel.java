package view;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.plugin.Plugin;

public class CenterPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected PluginFrame frame;
	protected JScrollPane scrollPane;
	protected JTextArea text;
	protected PluginsPanel panelPlugins;

	public CenterPanel(PluginFrame frame) {
		this.frame = frame;
		this.text = new JTextArea(20,65);
		this.scrollPane = new JScrollPane(this.text);
		this.panelPlugins=new PluginsPanel(frame);
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.add(scrollPane);
		this.add(panelPlugins);
	}
	
	public CenterPanel(PluginFrame frame, String text) {
		this(frame);
		this.text.setText(text);
	}
	
	public String getText(){
		return this.text.getText();
	}

	public void setText(String s) {
		this.text.setText(s);
	}

	public void pluginAdded(Plugin p) {
		this.panelPlugins.pluginAdded(p.getLabel());
	}
	public void pluginRemoved(Plugin p) {
		this.panelPlugins.pluginRemoved(p.getLabel());
	}
}
