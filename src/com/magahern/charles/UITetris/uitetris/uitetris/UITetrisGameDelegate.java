package com.magahern.charles.UITetris.uitetris.uitetris;

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

import com.magahern.charles.UITetris.uitetris.uitetris.impl.UITetronimo;

public interface UITetrisGameDelegate {
	/**
	 * Method : tetrisGameDidUpdate <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public abstract void tetrisGameDidUpdate(float dt);

	/**
	 * Method : tetrisBoardDidChange <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public abstract void tetrisBoardDidChange();

	/**
	 * Method : shouldDisplayNextTetronimo <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public abstract void shouldDisplayNextTetronimo(UITetronimo tetronimo);

	/**
	 * Method : shouldUpdateScore <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public abstract void shouldUpdateScore(long score);

	/**
	 * Method : clearedLinesAtRows <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public abstract void clearedLinesAtRows(long[] rows, long count);

	/**
	 * Method : gameOver <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public abstract void gameOver();
}
