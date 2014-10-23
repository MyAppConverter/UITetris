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

package com.magahern.charles.UITetris.uitetris.uitetris.impl;

import com.myappconverter.java.foundations.NSMutableString;
import com.myappconverter.java.foundations.NSString;
import com.myappconverter.java.foundations.utilities._NSUtilities;
import com.myappconverter.java.uikit.UIImage;
import com.myappconverter.java.uikit.UIImageView;

public class UITetronimo extends
		com.magahern.charles.UITetris.uitetris.uitetris.UITetronimo {

	int[] iBlock = { 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 };

	int[] jBlock = { 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0 };
	int[] lBlock = { 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0 };
	int[] oBlock = { 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0 };
	int[] sBlock = { 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 };
	int[] tBlock = { 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0 };
	int[] zBlock = { 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0 };

	static UIImage purpleBlockImg = null;
	static UIImage yellowBlockImg = null;
	static UIImage tealBlockImg = null;
	static UIImage redBlockImg = null;
	static UIImage greenBlockImg = null;
	static UIImage orangeBlockImg = null;
	static UIImage blueBlockImg = null;

	public UITetronimo() {
		super();
	}
	/**
	 * Method : UITetrisBlockCreate <!-- begin-user-doc -->
	 * 
	 * @return UITetrisBlock.
	 * @generated
	 */
	public static UITetrisBlock UITetrisBlockCreate(UITetrisBlockColor col) {
		UITetrisBlock blk = new UITetrisBlock();
		blk.color = col;
		_checkAndInitializeImages();
		UIImage image = null;
		switch (col) {
		case UITetrisBlockColorRed:
			image = redBlockImg;
			break;
		case UITetrisBlockColorPurple:
			image = purpleBlockImg;
			break;
		case UITetrisBlockColorGreen:
			image = greenBlockImg;
			break;
		case UITetrisBlockColorYellow:
			image = yellowBlockImg;
			break;
		case UITetrisBlockColorOrange:
			image = orangeBlockImg;
			break;
		case UITetrisBlockColorBlue:
			image = blueBlockImg;
			break;
		case UITetrisBlockColorTeal:
			image = tealBlockImg;
		default:
			break;

		}
		blk.imageView = new UIImageView();
		blk.imageView.initWithImage(image);
		return blk;
	}
	/**
	 * Method : UITetrisBlockCopy <!-- begin-user-doc -->
	 * 
	 * @return UITetrisBlock.
	 * @generated
	 */
	public static UITetrisBlock UITetrisBlockCopy(UITetrisBlock blk) {
		UITetrisBlock new_blk = new UITetrisBlock();
		new_blk.color = blk.color;
		new_blk.imageView = (UIImageView) blk.imageView.retain();
		return new_blk;
	}
	/**
	 * Method : UITetrisBlockFree <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public static void UITetrisBlockFree(UITetrisBlock blk) {
		if (blk != null) {
			blk.imageView.removeFromSuperview();
			blk.imageView.release();
			blk = null;
		}
	}
	/**
	 * Method : _checkAndInitializeImages <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public static void _checkAndInitializeImages() {

		boolean loadedAlready = true;

		loadedAlready &= purpleBlockImg != null;
		loadedAlready &= yellowBlockImg != null;
		loadedAlready &= tealBlockImg != null;
		loadedAlready &= redBlockImg != null;
		loadedAlready &= greenBlockImg != null;
		loadedAlready &= orangeBlockImg != null;
		loadedAlready &= blueBlockImg != null;
		if (!com.myappconverter.java.foundations.ExpressNullable
				.assertCondition(loadedAlready)) {
			purpleBlockImg = (UIImage) UIImage.imageNamed(
					new NSString("block_purple.png")).retain();
			yellowBlockImg = (UIImage) UIImage.imageNamed(
					new NSString("block_yellow.png")).retain();
			tealBlockImg = (UIImage) UIImage.imageNamed(
					new NSString("block_teal.png")).retain();
			redBlockImg = (UIImage) UIImage.imageNamed(
					new NSString("block_red.png")).retain();
			greenBlockImg = (UIImage) UIImage.imageNamed(
					new NSString("block_green.png")).retain();
			orangeBlockImg = (UIImage) UIImage.imageNamed(
					new NSString("block_orange.png")).retain();
			blueBlockImg = (UIImage) UIImage.imageNamed(
					new NSString("block_blue.png")).retain();
		}

	}

	/**
	 * Method : init <!-- begin-user-doc -->
	 * 
	 * @return UITetronimo.
	 * @generated
	 */
	public UITetronimo init() {
		super.init();
		if (this != null) {
			_blocks = new UITetrisBlock[16];
			type = UITetronimoType.UITetronimoTypeI;
			xPosition = yPosition = 0;
		}
		return this;
	}

	/**
	 * Method : initWithType <!-- begin-user-doc -->
	 * 
	 * @return UITetronimo.
	 * @generated
	 */
	public UITetronimo initWithType(UITetronimoType t) {
		this.init();
		if (this != null) {
			int[] blks;
			UITetrisBlockColor color;
			switch (t) {
			case UITetronimoTypeZ:
				blks = zBlock;
				color = UITetrisBlockColor.UITetrisBlockColorRed;
				break;
			case UITetronimoTypeT:
				blks = tBlock;
				color = UITetrisBlockColor.UITetrisBlockColorPurple;
				break;
			case UITetronimoTypeS:
				blks = sBlock;
				color = UITetrisBlockColor.UITetrisBlockColorGreen;
				break;
			case UITetronimoTypeO:
				blks = oBlock;
				color = UITetrisBlockColor.UITetrisBlockColorYellow;
				break;
			case UITetronimoTypeL:
				blks = lBlock;
				color = UITetrisBlockColor.UITetrisBlockColorOrange;
				break;
			case UITetronimoTypeJ:
				blks = jBlock;
				color = UITetrisBlockColor.UITetrisBlockColorBlue;
				break;
			case UITetronimoTypeI:
				blks = iBlock;
				color = UITetrisBlockColor.UITetrisBlockColorTeal;
			default:
				blks = tBlock;
				color = UITetrisBlockColor.UITetrisBlockColorPurple;
				break;
			}
			this.setType(t);
			for (int i = 0; i < 4 * 4; i++) {
				_blocks[i] = (blks[i] != 0 ? UITetrisBlockCreate(color) : null);
			}
		}
		return this;
	}

	/**
	 * Method : dealloc <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void dealloc() {
	}

	/**
	 * Method : blocks <!-- begin-user-doc -->
	 * 
	 * @return UITetrisBlock.
	 * @generated
	 */
	public UITetrisBlock[] blocks() {
		return _blocks;
	}

	/**
	 * Method : rotateRight <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void rotateRight() {
		UITetrisBlock[] blks = new UITetrisBlock[16];
		for (int i = 0; i < 4 * 4; i++) {
			int row;
			int col;
			row = (4 - 1) - (i % 4);
			col = i / 4;
			blks[i] = _blocks[row * 4 + col];
		}
		_NSUtilities.memcpy(_blocks, blks, 16);
	}

	/**
	 * Method : rotateLeft 
	 * <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void rotateLeft() {
		UITetrisBlock[] blks = new UITetrisBlock[16];
		for (int i = 0; i < 4 * 4; i++) {
			int row;
			int col;
			row = i % 4;
			col = 4 - i / 4 - 1;
			blks[i] = _blocks[row * 4 + col];
		}
		_NSUtilities.memcpy(_blocks, blks, 16);
	}

	/**
	 * Method : description <!-- begin-user-doc -->
	 * 
	 * @return NSString.
	 * @generated
	 */
	public NSString description() {
		NSMutableString str = NSMutableString.string();
		for (int i = 0; i < 4 * 4; i++) {
			if (i % 4 == 0) {
				str.appendString(new NSString("n"));
			} else {
				str.appendString(new NSString(" "));
			}
			str.appendFormat(new NSString("%c"), _blocks[i] != null ? 'o' : '.');
		}
		return str;
	}

}
