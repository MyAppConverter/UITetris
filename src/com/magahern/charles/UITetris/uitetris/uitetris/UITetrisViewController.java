
/*
 * Copyright (c) 2014 MyAppConverter
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MyAppConverter License v1.0
 * which accompanies this distribution, and is available at
 * http://www.myappconverter.com/legal/epl-v1.html
 *
 * Contributors:
 *    MyAppConverter Core Team - initial API and implementation
 * @date : Sep, 18 2014 - 11:03:50
 */

package com.magahern.charles.UITetris.uitetris.uitetris;

import com.myappconverter.java.avfoundation.AVAudioPlayer;
import com.magahern.charles.UITetris.uitetris.uitetris.impl.UITetrisGame;
import com.myappconverter.java.uikit.UIViewController;

public abstract class UITetrisViewController extends UIViewController implements
		com.myappconverter.java.uikit.protocols.UIAlertViewDelegate,
		UITetrisGameDelegate {

	/**
	 * The cached value of the '<em>tetrisGame</em>' property.
	 * 
	 * @see #getTetrisGame()
	 * @generated
	 * @ordered
	 */
	public UITetrisGame tetrisGame;

	/**
	 * The cached value of the '<em>musicPlayer</em>' property.
	 * 
	 * @see #getMusicPlayer()
	 * @generated
	 * @ordered
	 */
	public AVAudioPlayer musicPlayer;

	/**
	 * The cached value of the '<em>_touchDistanceMoved</em>' property.
	 * 
	 * @see #get_touchDistanceMoved()
	 * @generated
	 * @ordered
	 */
	public float _touchDistanceMoved;

}
