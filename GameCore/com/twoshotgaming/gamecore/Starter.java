package com.twoshotgaming.gamecore;

import javax.swing.SwingUtilities;
import com.twoshotgaming.gamecore.engine.Engine;

public class Starter {

	private static Engine gameEngineInstance = null;
	private static Thread gameThread;

	public static void main(String[] args) {

		if (gameEngineInstance == null) {
			gameEngineInstance = new Engine();
			gameThread = new Thread(gameEngineInstance);
			gameThread.start();
		}
		
		/*
		 * This is the recommended way to create a Swing event dispatch thread
		 * -- i.e. to run a Swing program.
		 */
		SwingUtilities.invokeLater(gameEngineInstance);
	}

	public static void runApp() {

		/*
		 * Create the model. It's a bit artificial to only be creating one model
		 * class called "Model". You may or may not have such a class. The
		 * important thing is to have a package called "model" or something
		 * along those lines, where you put your model code, however many
		 * classes are in the model.
		 */
		// Model model = new Model();

		/*
		 * Once again, you'll likely have a "view" package, not just one actual
		 * class called "View".
		 * 
		 * The view here listens to the model, but some implementations of MVC
		 * do not allow the view to touch the model in any way, rather only
		 * allowing the controller package classes to interact with model
		 * package classes.
		 */
		// View view = new View(model);

		/*
		 * Finally, the controller; once again, this should be a package, and
		 * you may even have multiple controllers, or one controller and many
		 * sub-controllers, etc. But for many apps, there will just be one
		 * controller which deals with routing all messages; it listens to the
		 * view and model and instructs both what to do.
		 */
		// Engine engine = new Engine(view, model);

		/*
		 * The controller must listen to the view to find out what happens in
		 * it. The controller should not be concerned with what actually happens
		 * in the view in terms of buttons and other widgets, but only a
		 * high-level view of instructions coming from the view (save
		 * such-and-such, adjust such-and-such, shutdown the app, etc).
		 */
		// display.setCreateUserListener(engine);
		// display.setSaveListener(engine);
		// display.setAppListener(engine);

		/*
		 * In this implementation of MVC, the view listens to the model and
		 * updates itself if the model changes. Some people say that the view
		 * should not touch the model, but that the controller should listen to
		 * the model and tell the view to change instead (by calling methods in
		 * the view package).
		 */
		// model.setPeopleChangedListener(view);
	}

}
