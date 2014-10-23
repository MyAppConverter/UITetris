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

import com.myappconverter.java.applicationservices.CGGeometry;
import com.myappconverter.java.applicationservices.CGPoint;
import com.myappconverter.java.applicationservices.CGRect;
import com.myappconverter.java.avfoundation.AVAudioPlayer;
import com.myappconverter.java.foundations.NSBundle;
import com.myappconverter.java.foundations.NSError;
import com.myappconverter.java.foundations.NSSet;
import com.myappconverter.java.foundations.NSString;
import com.myappconverter.java.foundations.NSURL;
import com.myappconverter.java.uikit.UIAlertView;
import com.myappconverter.java.uikit.UIApplication.UIInterfaceOrientation;
import com.myappconverter.java.uikit.UIEvent;
import com.myappconverter.java.uikit.UIScreen;
import com.myappconverter.java.uikit.UISwipeGestureRecognizer;
import com.myappconverter.java.uikit.UITouch;
import com.myappconverter.java.uikit.UIView;
import com.myappconverter.mapping.utils.Math;

public class UITetrisViewController extends
		com.magahern.charles.UITetris.uitetris.uitetris.UITetrisViewController {

	/**
	 * Method : init <!-- begin-user-doc -->
	 * 
	 * @return UITetrisViewController.
	 * @generated
	 */
	public UITetrisViewController init() {
		super.init();
		if (this != null) {
			tetrisGame = new UITetrisGame();
			tetrisGame.init();
			tetrisGame.setGameDelegate(this);
			tetrisGame.setGameSpeed(3.5f);
			tetrisGame.startGame();
			CGRect windowBounds = UIScreen.mainScreen().bounds();
			UITetrisView tetrisView = new UITetrisView();
			tetrisView.initWithFrame(CGGeometry.CGRectMake(0.0f, 0.0f,
					windowBounds.size.width, windowBounds.size.height));
			tetrisView.setGame(tetrisGame);
			this.setView(tetrisView);
			tetrisView.release();
			_touchDistanceMoved = 0.0f;
			NSError err = null;
			NSURL url = NSBundle.mainBundle().URLForResourceWithExtension(
					new NSString("tetris"), new NSString("mp3"));
			musicPlayer = new AVAudioPlayer();
			musicPlayer.initWithContentsOfURLError(url, err);
			musicPlayer.setNumberOfLoops(-1);
			musicPlayer.play();
		}
		return this;
	}

	@Override
	public void viewDidLoad() {
		super.viewDidLoad();
		this.view().willMoveToSuperview(this.view());

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
	 * Method : touchesBegan <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void touchesBeganWithEvent(NSSet touches, UIEvent event) {
		_touchDistanceMoved = 0.0f;
	}

	/**
	 * Method : touchesMoved <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void touchesMovedWithEvent(NSSet touches, UIEvent event) {
		UITouch touch = (UITouch) touches.anyObject();
		CGPoint previous;
		CGPoint now;
		float xDiff;
		float yDiff;
		float xDistanceMoved = 0.0f;
		float yDistanceMoved = 0.0f;
		previous = touch.previousLocationInView(this.view());
		now = touch.locationInView(this.view());
		xDiff = now.x - previous.x;
		yDiff = now.y - previous.y;
		_touchDistanceMoved += Math.fabsf(xDiff) + Math.fabsf(yDiff);
		if (xDistanceMoved > 0 && xDiff < 0 || xDistanceMoved < 0 && xDiff > 0) {
			xDistanceMoved = xDiff;
		} else {
			xDistanceMoved += xDiff;
		}
		if (yDistanceMoved > 0 && yDiff < 0 || yDistanceMoved < 0 && yDiff > 0) {
			yDistanceMoved = yDiff;
		} else {
			yDistanceMoved += yDiff;
		}
		if (Math.fabsf(xDistanceMoved) >= 22.0f) {
			if (xDistanceMoved < 0.0f) {
				tetrisGame
						.moveTetronimo(UITetrisGame.UITetronimoActionDirection.UITetronimoActionLeft);
			} else {
				if (xDistanceMoved > 0.0f) {
					tetrisGame
							.moveTetronimo(UITetrisGame.UITetronimoActionDirection.UITetronimoActionRight);
				}
			}
			xDistanceMoved = 0.0f;
		}
		if (yDistanceMoved >= 20.0f) {
			tetrisGame
					.moveTetronimo(UITetrisGame.UITetronimoActionDirection.UITetronimoActionDown);
			yDistanceMoved = 0.0f;
		}
	}

	/**
	 * Method : touchesEnded <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void touchesEndedWithEvent(NSSet touches, UIEvent event) {
		if (_touchDistanceMoved <= 5.0f) {
			CGPoint pt = ((UITouch) touches.anyObject()).locationInView(this
					.view());
			if (pt.x <= this.view().getBounds().size.width / 2.0f) {
				tetrisGame
						.rotateTetronimo(UITetrisGame.UITetronimoActionDirection.UITetronimoActionLeft);
			} else {
				tetrisGame
						.rotateTetronimo(UITetrisGame.UITetronimoActionDirection.UITetronimoActionRight);
			}
		}
	}

	/**
	 * Method : swipeDownGestureAction <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void swipeDownGestureAction(UISwipeGestureRecognizer recognizer) {
		tetrisGame.dropTetronimo();
	}

	/**
	 * Method : shouldAutorotateToInterfaceOrientation <!-- begin-user-doc -->
	 * 
	 * @return boolean.
	 * @generated
	 */
	public boolean shouldAutorotateToInterfaceOrientation(
			UIInterfaceOrientation interfaceOrientation) {
		return (interfaceOrientation == UIInterfaceOrientation.UIInterfaceOrientationPortrait);
	}

	/**
	 * Method : tetrisGameDidUpdate <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void tetrisGameDidUpdate(float dt) {
		if (com.myappconverter.java.foundations.ExpressNullable
				.assertCondition(this.isViewLoaded())) {
			((UITetrisView) this.view()).redraw();
		}
	}

	/**
	 * Method : shouldDisplayNextTetronimo <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void shouldDisplayNextTetronimo(UITetronimo tetronimo) {
		if (com.myappconverter.java.foundations.ExpressNullable
				.assertCondition(this.isViewLoaded())) {
			((UITetrisView) this.view()).updateNextTetronimoDisplay(tetronimo);
		}
	}

	/**
	 * Method : tetrisBoardDidChange <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void tetrisBoardDidChange() {
		if (com.myappconverter.java.foundations.ExpressNullable
				.assertCondition(this.isViewLoaded())) {
			((com.magahern.charles.UITetris.uitetris.uitetris.UITetrisView) this
					.view()).setBoardIsDirty(true);
		}
	}

	/**
	 * Method : shouldUpdateScore <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void shouldUpdateScore(long score) {
		if (com.myappconverter.java.foundations.ExpressNullable
				.assertCondition(this.isViewLoaded())) {
			((UITetrisView) this.view()).setScore(score);
		}
	}

	/**
	 * Method : clearedLinesAtRows <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void clearedLinesAtRows(long[] rows, long count) {
		if (com.myappconverter.java.foundations.ExpressNullable
				.assertCondition(this.isViewLoaded())) {
			((UITetrisView) this.view()).animateClearLinesAtRows(rows, count);
		}
	}

	/**
	 * Method : gameOver <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void gameOver() {
		NSString message = NSString.stringWithFormat(new NSString(
				"Your Score: %d"), tetrisGame.getScore());
		UIAlertView alert = (new UIAlertView())
				.initWithTitleMessageDelegateCancelButtonTitleOtherButtonTitles(
						new NSString("Game Over!"), message, this,
						new NSString("OK"), null);
		alert.show();
		alert.release();
	}

	/**
	 * Method : alertView <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	@Override
	public void alertViewClickedButtonAtIndex(UIAlertView alertView,
			int buttonIndex) {
		((UITetrisView) this.view()).setScore(0);
		UITetrisView vk = (UITetrisView) view;
		for (UIView view : vk._gameBoardView.subviews()) {
			view.removeFromSuperview();
		}
		tetrisGame.startGame();

	}

	@Override
	public boolean alertViewShouldEnableFirstOtherButton(UIAlertView alertView) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void willPresentAlertView(UIAlertView alertView) {
		// TODO Auto-generated method stub

	}

	@Override
	public void didPresentAlertView(UIAlertView alertView) {
		// TODO Auto-generated method stub

	}

	@Override
	public void alertViewWillDismissWithButtonIndex(UIAlertView alertView,
			int buttonIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void alertViewDidDismissWithButtonIndex(UIAlertView alertView,
			int buttonIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void alertViewCancel(UIAlertView alertView) {
		// TODO Auto-generated method stub

	}

}
