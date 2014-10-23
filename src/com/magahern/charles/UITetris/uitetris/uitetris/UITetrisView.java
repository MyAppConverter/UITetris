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

import android.view.ViewGroup;

import com.magahern.charles.UITetris.uitetris.uitetris.impl.UITetrisGame;
import com.magahern.charles.UITetris.uitetris.uitetris.impl.UITetronimo;
import com.myappconverter.java.uikit.UILabel;
import com.myappconverter.java.uikit.UIView;

public abstract class UITetrisView extends UIView {

	public UITetrisView(ViewGroup vg) {
		super(vg);
	}

	public UITetrisView() {
		super();
	}

	/**
	 * The cached value of the '<em>game</em>' property.
	 * 
	 * @see #getGame()
	 * @generated
	 * @ordered
	 */
	public UITetrisGame game;

	/**
	 * Returns the value of the '<em><b>game</b></em>' property.
	 * 
	 * @return UITetrisGame.
	 * @see #setGame(UITetrisGame)
	 * @generated
	 */
	public UITetrisGame getGame() {
		return this.game;
	}

	/**
	 * Sets the value of the '{@link <em>game</em>}' property.
	 * 
	 * @param UITetrisGame
	 *            the new value of the '<em>game</em>' property.
	 * @see #getGame()
	 * @generated
	 */
	public void setGame(UITetrisGame game) {
		this.game = game;
	}

	/**
	 * The cached value of the '<em>blockSize</em>' property.
	 * 
	 * @see #getBlockSize()
	 * @generated
	 * @ordered
	 */
	public float blockSize;

	/**
	 * Returns the value of the '<em><b>blockSize</b></em>' property.
	 * 
	 * @return float.
	 * @see #setBlockSize(float)
	 * @generated
	 */
	public float getBlockSize() {
		return this.blockSize;
	}

	/**
	 * Sets the value of the '{@link <em>blockSize</em>}' property.
	 * 
	 * @param float the new value of the '<em>blockSize</em>' property.
	 * @see #getBlockSize()
	 * @generated
	 */
	public void setBlockSize(float blockSize) {
		this.blockSize = blockSize;
	}

	/**
	 * The cached value of the '<em>boardIsDirty</em>' property.
	 * 
	 * @see #getBoardIsDirty()
	 * @generated
	 * @ordered
	 */
	public boolean boardIsDirty;

	/**
	 * Returns the value of the '<em><b>boardIsDirty</b></em>' property.
	 * 
	 * @return boolean.
	 * @see #setBoardIsDirty(boolean)
	 * @generated
	 */
	public boolean getBoardIsDirty() {
		return this.boardIsDirty;
	}

	/**
	 * Sets the value of the '{@link <em>boardIsDirty</em>}' property.
	 * 
	 * @param boolean the new value of the '<em>boardIsDirty</em>' property.
	 * @see #getBoardIsDirty()
	 * @generated
	 */
	public void setBoardIsDirty(boolean boardIsDirty) {
		this.boardIsDirty = boardIsDirty;
	}

	/**
	 * The cached value of the '<em>_gameBoardView</em>' property.
	 * 
	 * @see #get_gameBoardView()
	 * @generated
	 * @ordered
	 */

	public UIView _gameBoardView = new UIView();

	/**
	 * The cached value of the '<em>_nextTetronimoView</em>' property.
	 * 
	 * @see #get_nextTetronimoView()
	 * @generated
	 * @ordered
	 */

	public UIView _nextTetronimoView = new UIView();

	/**
	 * The cached value of the '<em>_nextTetronimoContentView</em>' property.
	 * 
	 * @see #get_nextTetronimoContentView()
	 * @generated
	 * @ordered
	 */

	public UIView _nextTetronimoContentView;

	/**
	 * The cached value of the '<em>_scoreLabel</em>' property.
	 * 
	 * @see #get_scoreLabel()
	 * @generated
	 * @ordered
	 */

	public UILabel _scoreLabel;

	/**
	 * Method : redraw <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public abstract void redraw();

	/**
	 * Method : updateNextTetronimoDisplay <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public abstract void updateNextTetronimoDisplay(UITetronimo tetronimo);

	/**
	 * Method : setScore <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public abstract void setScore(long score);

	/**
	 * Method : animateClearLinesAtRows <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public abstract void animateClearLinesAtRows(long[] rows, long count);
}
