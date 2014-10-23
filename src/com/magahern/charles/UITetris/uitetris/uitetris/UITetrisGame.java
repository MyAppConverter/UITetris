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

import com.myappconverter.java.foundations.NSMutableArray;
import com.myappconverter.java.foundations.NSTimer;
import com.myappconverter.java.foundations.NSDate;
import com.magahern.charles.UITetris.uitetris.uitetris.UITetronimo.UITetrisBlock;
import com.magahern.charles.UITetris.uitetris.uitetris.impl.UITetronimo;
import com.myappconverter.java.foundations.NSObject;

public abstract class UITetrisGame extends NSObject {
	/**
	 * Enum : UITetronimoActionDirection
	 * 
	 * @generated
	 */
	public enum UITetronimoActionDirection {

		UITetronimoActionLeft(0), UITetronimoActionRight(1), UITetronimoActionDown(
				2);
		private int value;

		private UITetronimoActionDirection(int value) {
			this.value = value;
		}
	};;

	/**
	 * The cached value of the '<em>fallingTetronimo</em>' property.
	 * 
	 * @see #getFallingTetronimo()
	 * @generated
	 * @ordered
	 */
	public UITetronimo fallingTetronimo;

	/**
	 * Returns the value of the '<em><b>fallingTetronimo</b></em>' property.
	 *
	 * @return UITetronimo.
	 * @see #setFallingTetronimo(UITetronimo)
	 * @generated
	 */
	public UITetronimo getFallingTetronimo() {
		return this.fallingTetronimo;
	}

	/**
	 * Sets the value of the '{@link <em>fallingTetronimo</em>}' property.
	 * 
	 * @param UITetronimo
	 *            the new value of the '<em>fallingTetronimo</em>' property.
	 * @see #getFallingTetronimo()
	 * @generated
	 */
	public void setFallingTetronimo(UITetronimo fallingTetronimo) {
		this.fallingTetronimo = fallingTetronimo;
	}

	/**
	 * The cached value of the '<em>isRunning</em>' property.
	 * 
	 * @see #getIsRunning()
	 * @generated
	 * @ordered
	 */
	public boolean isRunning;

	/**
	 * Returns the value of the '<em><b>isRunning</b></em>' property.
	 *
	 * @return boolean.
	 * @see #setIsRunning(boolean)
	 * @generated
	 */
	public boolean getIsRunning() {
		return this.isRunning;
	}

	/**
	 * Sets the value of the '{@link <em>isRunning</em>}' property.
	 * 
	 * @param boolean the new value of the '<em>isRunning</em>' property.
	 * @see #getIsRunning()
	 * @generated
	 */
	public void setIsRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	/**
	 * The cached value of the '<em>gameSpeed</em>' property.
	 * 
	 * @see #getGameSpeed()
	 * @generated
	 * @ordered
	 */
	public float gameSpeed;

	/**
	 * Returns the value of the '<em><b>gameSpeed</b></em>' property.
	 *
	 * @return float.
	 * @see #setGameSpeed(float)
	 * @generated
	 */
	public float getGameSpeed() {
		return this.gameSpeed;
	}

	/**
	 * Sets the value of the '{@link <em>gameSpeed</em>}' property.
	 * 
	 * @param float the new value of the '<em>gameSpeed</em>' property.
	 * @see #getGameSpeed()
	 * @generated
	 */
	public void setGameSpeed(float gameSpeed) {
		this.gameSpeed = gameSpeed;
	}

	/**
	 * The cached value of the '<em>score</em>' property.
	 * 
	 * @see #getScore()
	 * @generated
	 * @ordered
	 */
	public long score;

	/**
	 * Returns the value of the '<em><b>score</b></em>' property.
	 *
	 * @return long.
	 * @see #setScore(long)
	 * @generated
	 */
	public long getScore() {
		return this.score;
	}

	/**
	 * Sets the value of the '{@link <em>score</em>}' property.
	 * 
	 * @param long the new value of the '<em>score</em>' property.
	 * @see #getScore()
	 * @generated
	 */
	public void setScore(long score) {
		this.score = score;
	}

	/**
	 * The cached value of the '<em>_gameBoard</em>' property.
	 * 
	 * @see #get_gameBoard()
	 * @generated
	 * @ordered
	 */

	public UITetrisBlock[] _gameBoard;

	/**
	 * The cached value of the '<em>_nextTetronimos</em>' property.
	 * 
	 * @see #get_nextTetronimos()
	 * @generated
	 * @ordered
	 */

	public NSMutableArray _nextTetronimos;

	/**
	 * The cached value of the '<em>_gameTimer</em>' property.
	 * 
	 * @see #get_gameTimer()
	 * @generated
	 * @ordered
	 */

	public NSTimer _gameTimer;

	/**
	 * The cached value of the '<em>_lastFireDate</em>' property.
	 * 
	 * @see #get_lastFireDate()
	 * @generated
	 * @ordered
	 */

	public NSDate _lastFireDate;

	/**
	 * The cached value of the '<em>_nextStepTimeElapsed</em>' property.
	 * 
	 * @see #get_nextStepTimeElapsed()
	 * @generated
	 * @ordered
	 */

	public Double _nextStepTimeElapsed;

	/**
	 * The cached value of the '<em>gameDelegate</em>' property.
	 * 
	 * @see #getgameDelegate()
	 * @generated
	 * @ordered
	 */
	public UITetrisGameDelegate gameDelegate;

	/**
	 * Returns the value of the '<em><b>gameDelegate</b></em>' property.
	 *
	 * @return UITetrisGameDelegate.
	 * @see #setGameDelegate(UITetrisGameDelegate)
	 * @generated
	 */
	public UITetrisGameDelegate getGameDelegate() {
		return gameDelegate;
	}

	/**
	 * Sets the value of the '{@link <em>gameDelegate</em>}' property.
	 * 
	 * @param UITetrisGameDelegate
	 *            the new value of the '<em>gameDelegate</em>' property.
	 * @see #getGameDelegate()
	 * @generated
	 */
	public void setGameDelegate(UITetrisGameDelegate gameDelegate) {
		this.gameDelegate = gameDelegate;
	}

	/**
	 * Method : gameBoard <!-- begin-user-doc -->
	 * 
	 * @return UITetrisBlock.
	 * @generated
	 */
	public abstract UITetrisBlock[] gameBoard();

	/**
	 * Method : nextTetronimo <!-- begin-user-doc -->
	 * 
	 * @return UITetronimo.
	 * @generated
	 */
	public abstract UITetronimo nextTetronimo();

	/**
	 * Method : startGame <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public abstract void startGame();

	/**
	 * Method : pauseGame <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public abstract void pauseGame();

	/**
	 * Method : moveTetronimo <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public abstract void moveTetronimo(UITetronimoActionDirection direction);

	/**
	 * Method : rotateTetronimo <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public abstract void rotateTetronimo(UITetronimoActionDirection direction);

	/**
	 * Method : dropTetronimo <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public abstract void dropTetronimo();

	/**
	 * Method : fillBoardWithTestBlocks <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public abstract void fillBoardWithTestBlocks();
}
