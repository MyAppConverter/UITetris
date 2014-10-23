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

import com.magahern.charles.UITetris.uitetris.uitetris.UITetrisGameDelegate;
import com.magahern.charles.UITetris.uitetris.uitetris.UITetronimo.UITetrisBlock;
import com.magahern.charles.UITetris.uitetris.uitetris.UITetronimo.UITetronimoType;
import com.myappconverter.java.foundations.NSArray;
import com.myappconverter.java.foundations.NSDate;
import com.myappconverter.java.foundations.NSMutableArray;
import com.myappconverter.java.foundations.NSObject;
import com.myappconverter.java.foundations.NSRunLoop;
import com.myappconverter.java.foundations.NSString;
import com.myappconverter.java.foundations.NSTimer;
import com.myappconverter.java.foundations.SEL;
import com.myappconverter.mapping.utils.Math;

public class UITetrisGame extends
		com.magahern.charles.UITetris.uitetris.uitetris.UITetrisGame {

	/**
	 * Enum : UITetrisCollisionType
	 * 
	 * @generated
	 */
	public enum UITetrisCollisionType {

		UITetrisCollisionTypeBounds(0), UITetrisCollisionTypeBlocks(1), UITetrisCollisionTypeBoth(
				2);
		private int value;

		private UITetrisCollisionType(int value) {
			this.value = value;
		}
	}

	/**
	 * Method : init <!-- begin-user-doc -->
	 * 
	 * @return UITetrisGame.
	 * @generated
	 */
	public UITetrisGame init() {
		super.init();
		if (this != null) {
			_gameBoard = new UITetrisBlock[20 * 10];
			_nextTetronimos = new NSMutableArray();
			_nextTetronimos.init();
			_gameTimer = null;
			_lastFireDate = (NSDate) NSDate.date().retain();
			_nextStepTimeElapsed = (double) 0.0f;
			fallingTetronimo = null;
			isRunning = false;
			gameSpeed = 1.0f;
			score = 0;
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
	 * Method : gameBoard <!-- begin-user-doc -->
	 * 
	 * @return UITetrisBlock.
	 * @generated
	 */
	public UITetrisBlock[] gameBoard() {
		return _gameBoard;
	}

	/**
	 * Method : nextTetronimo <!-- begin-user-doc -->
	 * 
	 * @return UITetronimo.
	 * @generated
	 */
	public UITetronimo nextTetronimo() {
		if (_nextTetronimos.count() == 0) {
			_nextTetronimos.addObjectsFromArray(this._randomTetronimoSet());
		}
		return (UITetronimo) _nextTetronimos.lastObject();
	}

	/**
	 * Method : _solidifyFallingTetronimo <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void _solidifyFallingTetronimo() {
		if (fallingTetronimo == null) {
			return;
		}
		UITetrisBlock[] blocks = fallingTetronimo.blocks();
		int row;
		int col;
		int idx;
		for (int i = 0; i < 4 * 4; i++) {
			if (blocks[i] != null) {
				row = fallingTetronimo.getYPosition() + i / 4;
				col = fallingTetronimo.getXPosition() + i % 4;
				idx = (row * 10) + col;
				_gameBoard[idx] = UITetronimo.UITetrisBlockCopy(blocks[i]);
			}
		}
		this._checkLinesCleared();
		this.getGameDelegate().tetrisBoardDidChange();
	}

	/**
	 * Method : _checkCollisionsOfType <!-- begin-user-doc -->
	 * 
	 * @return boolean.
	 * @generated
	 */
	public boolean _checkCollisionsOfType(UITetrisCollisionType type) {
		if (fallingTetronimo == null) {
			return false;
		}
		UITetrisBlock[] blocks = fallingTetronimo.blocks();
		int row;
		int col;
		int idx;
		for (int i = 0; i < 4 * 4; i++) {
			if (blocks[i] != null) {
				row = fallingTetronimo.getYPosition() + i / 4;
				col = fallingTetronimo.getXPosition() + i % 4;
				idx = (row * 10) + col;
				if (type == UITetrisGame.UITetrisCollisionType.UITetrisCollisionTypeBounds
						|| type == UITetrisGame.UITetrisCollisionType.UITetrisCollisionTypeBoth) {
					if (row >= 20 || col >= 10 || col < 0) {
						return true;
					}
				}
				if (type == UITetrisGame.UITetrisCollisionType.UITetrisCollisionTypeBlocks
						|| type == UITetrisGame.UITetrisCollisionType.UITetrisCollisionTypeBoth) {
					if (idx >= 0 && idx < 20 * 10 && _gameBoard[idx] != null) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Method : _checkBlockCollisions <!-- begin-user-doc -->
	 * 
	 * @return boolean.
	 * @generated
	 */
	public boolean _checkBlockCollisions() {
		return this
				._checkCollisionsOfType(UITetrisGame.UITetrisCollisionType.UITetrisCollisionTypeBlocks);
	}

	/**
	 * Method : _checkBounds <!-- begin-user-doc -->
	 * 
	 * @return boolean.
	 * @generated
	 */
	public boolean _checkBounds() {
		return this
				._checkCollisionsOfType(UITetrisGame.UITetrisCollisionType.UITetrisCollisionTypeBounds);
	}

	/**
	 * Method : _checkLinesCleared <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void _checkLinesCleared() {
		long[] rows = new long[20];
		long count = 0;
		for (int i = 0; i < 20 * 10; i += 10) {
			boolean shouldClearLine = true;
			for (int j = i; j < i + 10; j++) {
				shouldClearLine &= _gameBoard[j] != null;
			}
			if (com.myappconverter.java.foundations.ExpressNullable
					.assertCondition(shouldClearLine)) {
				rows[(int) count++] = i / 10;
			}
		}
		for (int i = 0; i < count; i++) {
			this._clearLineAtRow(rows[i]);
		}
		this.getGameDelegate().clearedLinesAtRows(rows, count);
	}

	/**
	 * Method : _clearLineAtRow <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void _clearLineAtRow(long row) {
		int idx = (int) (row * 10);
		for (int i = idx; i < idx + 10 && i < 20 * 10; i++) {
			if (_gameBoard[i] != null) {
				UITetronimo.UITetrisBlockFree(_gameBoard[i]);
				_gameBoard[i] = null;
			}
		}
		for (int i = idx - 1; i >= 0; i--) {
			_gameBoard[i + 10] = _gameBoard[i];
			_gameBoard[i] = null;
		}
		this.score++;
		this.getGameDelegate().tetrisBoardDidChange();
		this.getGameDelegate().shouldUpdateScore(this.getScore());
	}

	/**
	 * Method : moveTetronimo <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void moveTetronimo(UITetronimoActionDirection direction) {
		if (fallingTetronimo != null) {
			if (direction != UITetrisGame.UITetronimoActionDirection.UITetronimoActionDown) {
				fallingTetronimo
						.setXPosition(fallingTetronimo.xPosition
								+ (direction == UITetronimoActionDirection.UITetronimoActionLeft ? -1
										: 1));
				if (com.myappconverter.java.foundations.ExpressNullable
						.assertCondition(this
								._checkCollisionsOfType(UITetrisGame.UITetrisCollisionType.UITetrisCollisionTypeBoth))) {
					fallingTetronimo
							.setXPosition(fallingTetronimo.xPosition
									+ (direction == UITetronimoActionDirection.UITetronimoActionLeft ? 1
											: -1));
				}
			} else {
				fallingTetronimo
						.setYPosition(fallingTetronimo.getYPosition() + 1);
				;
				if (com.myappconverter.java.foundations.ExpressNullable
						.assertCondition(this
								._checkCollisionsOfType(UITetrisGame.UITetrisCollisionType.UITetrisCollisionTypeBoth))) {
					fallingTetronimo.yPosition--;
					this._solidifyFallingTetronimo();
					this._placeAndSetNextTetronimo();
				}
			}
		}
	}

	/**
	 * Method : rotateTetronimo <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void rotateTetronimo(UITetronimoActionDirection direction) {
		if (fallingTetronimo != null) {
			if (direction == UITetrisGame.UITetronimoActionDirection.UITetronimoActionLeft) {
				fallingTetronimo.rotateLeft();
			} else {
				fallingTetronimo.rotateRight();
			}
			fallingTetronimo.yPosition++;
			if (com.myappconverter.java.foundations.ExpressNullable
					.assertCondition(this._checkBlockCollisions())
					|| fallingTetronimo.getYPosition() + 2 >= 20) {
				_nextStepTimeElapsed = -0.6;
			}
			fallingTetronimo.yPosition--;
			int cheatCounter = 0;
			int tetronimoChange = 0;
			boolean shouldRotate = true;
			int cheatAllowed = 5;
			while (com.myappconverter.java.foundations.ExpressNullable
					.assertCondition(this._checkBounds())) {
				int change = (fallingTetronimo.getXPosition() < 10 / 2 ? 1 : -1);
				fallingTetronimo.setXPosition(fallingTetronimo.xPosition
						+ change);
				tetronimoChange += change;
				cheatCounter++;
				if (cheatCounter >= cheatAllowed) {
					break;
				}
			}
			if (cheatCounter >= cheatAllowed) {
				shouldRotate = false;
				fallingTetronimo.setXPosition(fallingTetronimo.xPosition
						- tetronimoChange);
			}
			tetronimoChange = 0;
			cheatCounter = 0;
			if (com.myappconverter.java.foundations.ExpressNullable
					.assertCondition(shouldRotate)) {
				while (com.myappconverter.java.foundations.ExpressNullable
						.assertCondition(this._checkBlockCollisions())) {
					fallingTetronimo.yPosition--;
					tetronimoChange--;
					cheatCounter++;
					if (cheatCounter >= cheatAllowed) {
						break;
					}
				}
				if (cheatCounter >= cheatAllowed) {
					shouldRotate = false;
					fallingTetronimo.setYPosition(fallingTetronimo.yPosition
							+ tetronimoChange);
				} else {
					if (fallingTetronimo.getYPosition() <= -3) {
						this._gameOver();
					}
				}
			}
			if (!com.myappconverter.java.foundations.ExpressNullable
					.assertCondition(shouldRotate)) {
				if (direction == UITetrisGame.UITetronimoActionDirection.UITetronimoActionLeft) {
					fallingTetronimo.rotateRight();
				} else {
					fallingTetronimo.rotateLeft();
				}
			}
		}
	}

	/**
	 * Method : dropTetronimo <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void dropTetronimo() {
		while (!this
				._checkCollisionsOfType(UITetrisGame.UITetrisCollisionType.UITetrisCollisionTypeBoth)) {
			fallingTetronimo.yPosition++;
		}
		fallingTetronimo.yPosition--;
		this._solidifyFallingTetronimo();
		this._placeAndSetNextTetronimo();
	}

	/**
	 * Method : _gameOver <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void _gameOver() {
		isRunning = false;
		if (com.myappconverter.java.foundations.ExpressNullable
				.assertCondition(this._verifyGameDelegateForSelector(new SEL(
						new NSString("gameOver"))))) {
			this.getGameDelegate().gameOver();
		}
	}

	/**
	 * Method : _resetGameBoard <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void _resetGameBoard() {
		for (int i = 0; i < _gameBoard.length; i++) {
			if (_gameBoard[i] != null) {
				UITetronimo.UITetrisBlockFree(_gameBoard[i]);
				_gameBoard[i] = null;
			}
		}
		this.getGameDelegate().tetrisBoardDidChange();
	}

	/**
	 * Method : startGame <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void startGame() {
		if (_gameTimer == null) {
			_gameTimer = new NSTimer();
			_gameTimer.initWithFireDateIntervalTargetSelectorUserInfoRepeats(
					NSDate.date(), 0.03f, this,
					new SEL(new NSString("_update")), null, true);
			NSRunLoop.currentRunLoop().addTimerForMode(_gameTimer,
					NSRunLoop.NSRunLoopCommonModes);
		}
		this.setScore(0);
		this._resetGameBoard();
		this._placeAndSetNextTetronimo();
		isRunning = true;
	}

	/**
	 * Method : pauseGame <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void pauseGame() {
		isRunning = false;
	}

	/**
	 * Method : _getDeltaTime <!-- begin-user-doc -->
	 * 
	 * @return float.
	 * @generated
	 */
	public float _getDeltaTime() {
		double delta = _lastFireDate.timeIntervalSinceNow() * -1.0f;
		_lastFireDate.release();
		_lastFireDate = (NSDate) NSDate.date().retain();
		return (float) delta;
	}

	/**
	 * Method : _verifyGameDelegateForSelector <!-- begin-user-doc -->
	 * 
	 * @return boolean.
	 * @generated
	 */
	public boolean _verifyGameDelegateForSelector(SEL selector) {
		return (this.getGameDelegate() != null
				&& ((NSObject) this.getGameDelegate())
						.conformsToProtocol(UITetrisGameDelegate.class) && ((NSObject) this
					.getGameDelegate()).respondsToSelector(selector));
	}

	/**
	 * Method : _update <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void _update() {
		if (!this.getIsRunning()) {
			return;
		}
		float dt = this._getDeltaTime();
		if (_nextStepTimeElapsed >= 1.0f / gameSpeed
				&& this.getFallingTetronimo() != null) {
			this.getFallingTetronimo().yPosition++;
			if (com.myappconverter.java.foundations.ExpressNullable
					.assertCondition(this
							._checkCollisionsOfType(UITetrisGame.UITetrisCollisionType.UITetrisCollisionTypeBoth))) {
				this.getFallingTetronimo().yPosition--;
				if (this.getFallingTetronimo().getYPosition() <= -3) {
					this._gameOver();
				} else {
					this._solidifyFallingTetronimo();
					this._placeAndSetNextTetronimo();
				}
			}
			_nextStepTimeElapsed = 0.0;
		}
		_nextStepTimeElapsed += dt;
		this.getGameDelegate().tetrisGameDidUpdate(dt);
	}

	/**
	 * Method : _randomTetronimo <!-- begin-user-doc -->
	 * 
	 * @return UITetronimo.
	 * @generated
	 */
	public UITetronimo _randomTetronimo() {
		int rand = Math.arc4random() % 6;
		UITetronimo tetronimo = (new UITetronimo())
				.initWithType(UITetronimoType.setValue(rand));
		return (UITetronimo) tetronimo.autorelease();
	}

	/**
	 * Method : _randomTetronimoSet <!-- begin-user-doc -->
	 * 
	 * @return NSArray.
	 * @generated
	 */
	public NSArray _randomTetronimoSet() {
		int[] types = { 0, 1, 2, 3, 4, 5, 6 };
		NSMutableArray result = (NSMutableArray) (new NSMutableArray())
				.initWithCapacity(7);
		int rand;
		int temp;
		int newIdx;
		for (int i = 0; i < 7; i++) {
			rand = Math.arc4random() % 6;
			newIdx = (i + rand) % 6;
			temp = types[newIdx];
			types[newIdx] = types[i];
			types[i] = temp;
		}
		for (int i = 0; i < 7; i++) {
			UITetronimo tet = (new UITetronimo()).initWithType(UITetronimoType
					.setValue(types[i]));
			result.addObject(tet);
			tet.release();
		}
		return (NSArray) result.autorelease();
	}

	/**
	 * Method : _popTetronimo <!-- begin-user-doc -->
	 * 
	 * @return UITetronimo.
	 * @generated
	 */
	public UITetronimo _popTetronimo() {
		if (_nextTetronimos == null) {
			return null;
		}
		if (_nextTetronimos.count() == 0) {
			NSArray tets = this._randomTetronimoSet();
			_nextTetronimos.addObjectsFromArray(tets);
		}
		UITetronimo result = (UITetronimo) ((UITetronimo) _nextTetronimos
				.lastObject()).retain();
		_nextTetronimos.removeLastObject();
		return (UITetronimo) result.autorelease();
	}

	/**
	 * Method : _placeAndSetNextTetronimo <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void _placeAndSetNextTetronimo() {
		UITetronimo tet = this._popTetronimo();
		tet.setXPosition(10 / 3);
		tet.setYPosition(-2);
		this.setFallingTetronimo(tet);
		if (com.myappconverter.java.foundations.ExpressNullable
				.assertCondition(this._checkBlockCollisions())) {
			this._gameOver();
		}
		this.getGameDelegate().shouldDisplayNextTetronimo(this.nextTetronimo());
	}

	/**
	 * Method : fillBoardWithTestBlocks <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void fillBoardWithTestBlocks() {
		for (int i = 10 * 10; i < 20 * 10; i++) {
			if ((i + 1) % 10 != 0) {
				_gameBoard[i] = UITetronimo
						.UITetrisBlockCreate(UITetronimo.UITetrisBlockColor.UITetrisBlockColorRed);
			}
		}
		this.getGameDelegate().tetrisBoardDidChange();
	}

}
