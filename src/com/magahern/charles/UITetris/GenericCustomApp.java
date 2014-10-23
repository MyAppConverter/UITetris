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
 * @date : Sep, 18 2014 - 11:03:51
 */

package com.magahern.charles.UITetris;

import android.app.Application;

import com.magahern.charles.UITetris.uitetris.uitetris.impl.UITetrisViewController;
import com.myappconverter.java.uikit.UIWindow;

public class GenericCustomApp extends Application {

	/**
	 * The cached value of the '<em>window</em>' property.
	 * 
	 * @see #getWindow()
	 * @generated
	 * @ordered
	 */
	public UIWindow window;

	/**
	 * Returns the value of the '<em><b>window</b></em>' property.
	 *
	 * @return UIWindow.
	 * @see #setWindow(UIWindow)
	 * @generated
	 */
	public UIWindow getWindow() {
		return this.window;
	}

	/**
	 * Sets the value of the '{@link <em>window</em>}' property.
	 * 
	 * @param UIWindow
	 *            the new value of the '<em>window</em>' property.
	 * @see #getWindow()
	 * @generated
	 */
	public void setWindow(UIWindow window) {
		this.window = window;
	}

	/**
	 * The cached value of the '<em>tetrisViewController</em>' property.
	 * 
	 * @see #getTetrisViewController()
	 * @generated
	 * @ordered
	 */
	public UITetrisViewController tetrisViewController;

	/**
	 * Returns the value of the '<em><b>tetrisViewController</b></em>' property.
	 *
	 * @return UITetrisViewController.
	 * @see #setTetrisViewController(UITetrisViewController)
	 * @generated
	 */
	public UITetrisViewController getTetrisViewController() {
		return this.tetrisViewController;
	}

	/**
	 * Sets the value of the '{@link <em>tetrisViewController</em>}' property.
	 * 
	 * @param UITetrisViewController
	 *            the new value of the '<em>tetrisViewController</em>' property.
	 * @see #getTetrisViewController()
	 * @generated
	 */
	public void setTetrisViewController(
			UITetrisViewController tetrisViewController) {
		this.tetrisViewController = tetrisViewController;
	}

	@Override
	public void onTerminate() {
		super.onTerminate();

	}

}
