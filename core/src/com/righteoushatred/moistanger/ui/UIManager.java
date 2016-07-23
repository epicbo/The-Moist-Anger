package com.righteoushatred.moistanger.ui;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class UIManager {

	private ArrayList<UIComponent> components;

	private UIComponent grabbedComponent;

	private float grabbedX;

	private float grabbedY;


	public UIManager() {
		components = new ArrayList<UIComponent>();
	}

	public void update(float delta) {


		for (UIComponent c : components)
			c.update(delta);
	}

	public void render(SpriteBatch batch) {

		if (grabbedComponent != null) {
			if (components.contains(grabbedComponent)) {

				// Move the grabbed object to the end of the queue so it's rendered on top
				components.remove(grabbedComponent);
				components.add(grabbedComponent);
			} 
		}

		for (UIComponent c : components) 
			c.renderComponent(batch);
	}

	public void setSelectedComponent(UIComponent component) {

		for (UIComponent c : components)
			c.setSelected(false);

		if (component != null)
			component.setSelected(true);
	}	

	public void addComponent(UIComponent component) {
		if (!components.contains(component)) {
			components.add(component);
			component.setUIManager(this);
		}
	}

	public void setComponentGrabbed(UIComponent grabbedComponent, boolean grabbed, float grabbedX, float grabbedY) {

		if (grabbed) {
			this.grabbedComponent = grabbedComponent;
			this.grabbedX = grabbedX;
			this.grabbedY = grabbedY;
			
			
		} else if (this.grabbedComponent == grabbedComponent && !grabbed) {

			for (int i = 0; i<components.size(); i++) {
				UIComponent c = components.get(components.size() - i - 1);

				//TODO if (c.getX() >= grabbedC)
			}

			this.grabbedComponent = null;
		}
	}

	public float getComponentScreenX(UIComponent component, float x) {

		UIComponent c = component;

		while (c.getParent() != null) {
			x += c.getParent().getX();
			c = c.getParent();
		}

		return x;
	}

	public float getComponentScreenY(UIComponent component, float y) {

		UIComponent c = component;

		while (c.getParent() != null) {
			y += c.getParent().getY();
			c = c.getParent();
		}

		return y;
	}
	
	public float screenToRelativeX(UIComponent component, float x) {
		
		UIComponent c = component;

		while (c.getParent() != null) {
			x -= c.getParent().getX();
			c = c.getParent();
		}

		return x;
	}
	
	public float screenToRelativeY(UIComponent component, float y) {
		
		UIComponent c = component;

		while (c.getParent() != null) {
			y -= c.getParent().getY();
			c = c.getParent();
		}

		return y;
	}

	public boolean mousePressed(int button, int x, int y) {

		y = Gdx.graphics.getHeight() - y;

		for (UIComponent c : components)
			if (c.mousePressedComponent(button, x, y))
				return true;

		return false;
	}

	public boolean mouseReleased(int button, int x, int y) {

		y = Gdx.graphics.getHeight() - y;

		for (UIComponent c : components)
			c.mouseReleasedComponent(button, x, y);

		return false;
	}

	public boolean mouseMoved(int button, int x, int y) {

		y = Gdx.graphics.getHeight() - y;

		if (grabbedComponent != null) {


			grabbedComponent.setX(screenToRelativeX(grabbedComponent, x-grabbedX));
			grabbedComponent.setY(screenToRelativeY(grabbedComponent, y-grabbedY));
		}

		for (UIComponent c : components)
			c.mouseMovedComponent(button, x, y);

		return false;
	}

	public boolean keyTyped(char c) {

		for (UIComponent co : components)
			co.keyTyped(c);

		return false;
	}

	public UIComponent getGrabbedComponent() {
		return grabbedComponent;
	}

}
