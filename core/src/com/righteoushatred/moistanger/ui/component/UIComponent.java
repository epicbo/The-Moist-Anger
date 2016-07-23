package com.righteoushatred.moistanger.ui.component;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.episkbo.episkui.UIManager;
                
public abstract class UIComponent {

	protected float x;
	
	protected float y;
	
	protected float width;
	
	protected float height;
	
	protected boolean visible;
	
	protected boolean enabled;
	
	protected float borderWidth;
	
	private boolean selected;
	
	protected UIManager uiManager;
	
	protected ArrayList<UIComponent> components;
	
	protected UIComponent parent;
	
	public UIComponent() {
		components = new ArrayList<UIComponent>();
		enabled = true;
		visible = true;
		borderWidth = 2;
	}
	
	public void update(float delta) {
		
	}
	
	protected void renderComponent(SpriteBatch batch) {
		renderComponent(batch, 0, 0);
	}
	
	private void renderComponent(SpriteBatch batch, float offsetX, float offsetY) {
		render(batch, x+offsetX, y+offsetY);
		
		for (int i = 0; i<components.size(); i++)
			components.get(i).renderComponent(batch, x + offsetX, y + offsetY);
	}
	
	protected boolean mousePressedComponent(int button, int x, int y) {
		
		for (int i = 0; i<components.size(); i++)
			if (components.get(i).mousePressedComponent(button, x-(int)this.x, y-(int)this.y))
				return true;
			
		return mousePressed(button, x, y);
	}
	
	protected boolean mouseReleasedComponent(int button, int x, int y) {
		
		for (int i = 0; i<components.size(); i++)
			if (components.get(i).mouseReleasedComponent(button, x-(int)this.x, y-(int)this.y))
				return true;
			
		return mouseReleased(button, x, y);
	}
	
	protected boolean mouseMovedComponent(int button, int x, int y) {
	
		for (int i = 0; i<components.size(); i++)
			if (components.get(i).mouseMovedComponent(button, x-(int)this.x, y-(int)this.y))
				return true;
			
		return mouseMoved(button, x, y);
	}
	
	public abstract boolean mousePressed(int button, int x, int y);
	
	public abstract boolean mouseReleased(int button, int x, int y);
	
	public abstract boolean mouseMoved(int button, int x, int y);
	
	public boolean keyTyped(char c) {
		return false;
	}
	
	public abstract void render(SpriteBatch batch, float x, float y);

	public void addComponent(UIComponent component) {
		components.add(component);
		component.uiManager = uiManager;
		component.parent = this;
	}
	
	public void removeComponent(UIComponent component) {
		components.remove(component);
		component.uiManager = null;
		component.parent = null;
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
		
		for (int i = 0; i<components.size(); i++)
			components.get(i).setVisible(visible);
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		
		for (int i = 0; i<components.size(); i++)
			components.get(i).setEnabled(enabled);
	}

	public float getBorderWidth() {
		return borderWidth;
	}

	public void setBorderWidth(float borderWidth) {
		this.borderWidth = borderWidth;
	}

	public void setUIManager(UIManager uiManager) {
		this.uiManager = uiManager;
		
		for (int i = 0; i<components.size(); i++)
			components.get(i).setUIManager(uiManager);
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
		
		for (int i = 0; i<components.size(); i++)
			components.get(i).setSelected(selected);
	}
	
	public void setGrabbed(boolean grabbed, int x, int y) {
		uiManager.setComponentGrabbed(this, grabbed, x-this.x, y-this.y);
	}
	
	public void componentDropped(UIComponent component, int x, int y) {
		
	}

	public UIComponent getParent() {
		return parent;
	}
}
