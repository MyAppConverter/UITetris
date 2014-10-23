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

import com.myappconverter.java.foundations.NSObject;

public abstract class UITetronimo extends NSObject {

	public static class UITetrisBlock extends tetris_block_t {
	}

	/**
	 * Enum : UITetrisBlockColor
	 * 
	 * @generated
	 */
	public enum UITetrisBlockColor {

		UITetrisBlockColorTeal(0), UITetrisBlockColorBlue(1), UITetrisBlockColorOrange(
				2), UITetrisBlockColorYellow(3), UITetrisBlockColorGreen(4), UITetrisBlockColorPurple(
				5), UITetrisBlockColorRed(6);
		private int value;

		private UITetrisBlockColor(int value) {
			this.value = value;
		}
	};

	/**
	 * Enum : UITetronimoType
	 * 
	 * @generated
	 */
	public enum UITetronimoType {

		UITetronimoTypeI(0), UITetronimoTypeJ(1), UITetronimoTypeL(2), UITetronimoTypeO(
				3), UITetronimoTypeS(4), UITetronimoTypeT(5), UITetronimoTypeZ(
				6);
		public int value;

		private UITetronimoType(int value) {
			this.value = value;
		}

		public static UITetronimoType setValue(int value) {
			UITetronimoType type = UITetronimoType.UITetronimoTypeI;
			if (value == 1) {
				type = UITetronimoTypeJ;
			} else if (value == 2) {
				type = UITetronimoTypeL;
			} else if (value == 3) {
				type = UITetronimoTypeO;
			} else if (value == 4) {
				type = UITetronimoTypeS;
			} else if (value == 5) {
				type = UITetronimoTypeT;
			} else if (value == 6) {
				type = UITetronimoTypeZ;
			}
			return type;
		}

	};

	/**
	 * The cached value of the '<em>blocks</em>' property.
	 * 
	 * @see #getBlocks()
	 * @generated
	 * @ordered
	 */
	public UITetrisBlock[] blocks;

	/**
	 * Returns the value of the '<em><b>blocks</b></em>' property.
	 * 
	 * @return UITetrisBlock.
	 * @see #setBlocks(UITetrisBlock)
	 * @generated
	 */
	public UITetrisBlock[] getBlocks() {
		return this.blocks;
	}

	/**
	 * Sets the value of the '{@link <em>blocks</em>}' property.
	 * 
	 * @param UITetrisBlock
	 *            the new value of the '<em>blocks</em>' property.
	 * @see #getBlocks()
	 * @generated
	 */
	public void setBlocks(UITetrisBlock[] blocks) {
		this.blocks = blocks;
	}

	/**
	 * The cached value of the '<em>type</em>' property.
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	public UITetronimoType type;

	/**
	 * Returns the value of the '<em><b>type</b></em>' property.
	 * 
	 * @return UITetronimoType.
	 * @see #setType(UITetronimoType)
	 * @generated
	 */
	public UITetronimoType getType() {
		return this.type;
	}

	/**
	 * Sets the value of the '{@link <em>type</em>}' property.
	 * 
	 * @param UITetronimoType
	 *            the new value of the '<em>type</em>' property.
	 * @see #getType()
	 * @generated
	 */
	public void setType(UITetronimoType type) {
		this.type = type;
	}

	/**
	 * The cached value of the '<em>xPosition</em>' property.
	 * 
	 * @see #getXPosition()
	 * @generated
	 * @ordered
	 */
	public int xPosition;

	/**
	 * Returns the value of the '<em><b>xPosition</b></em>' property.
	 * 
	 * @return int.
	 * @see #setXPosition(int)
	 * @generated
	 */
	public int getXPosition() {
		return this.xPosition;
	}

	/**
	 * Sets the value of the '{@link <em>xPosition</em>}' property.
	 * 
	 * @param int the new value of the '<em>xPosition</em>' property.
	 * @see #getXPosition()
	 * @generated
	 */
	public void setXPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	/**
	 * The cached value of the '<em>yPosition</em>' property.
	 * 
	 * @see #getYPosition()
	 * @generated
	 * @ordered
	 */
	public int yPosition;

	/**
	 * Returns the value of the '<em><b>yPosition</b></em>' property.
	 * 
	 * @return int.
	 * @see #setYPosition(int)
	 * @generated
	 */
	public int getYPosition() {
		return this.yPosition;
	}

	/**
	 * Sets the value of the '{@link <em>yPosition</em>}' property.
	 * 
	 * @param int the new value of the '<em>yPosition</em>' property.
	 * @see #getYPosition()
	 * @generated
	 */
	public void setYPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	/**
	 * The cached value of the '<em>_blocks</em>' property.
	 * 
	 * @see #get_blocks()
	 * @generated
	 * @ordered
	 */

	public UITetrisBlock[] _blocks;

	/**
	 * Method : initWithType <!-- begin-user-doc -->
	 * 
	 * @return UITetronimo.
	 * @generated
	 */
	public abstract UITetronimo initWithType(UITetronimoType type);

	/**
	 * Method : rotateRight <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public abstract void rotateRight();

	/**
	 * Method : rotateLeft <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public abstract void rotateLeft();
}
