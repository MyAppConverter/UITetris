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

import android.view.ViewGroup;

import com.magahern.charles.UITetris.uitetris.uitetris.UITetronimo.UITetrisBlock;
import com.myappconverter.java.appkit.NSText;
import com.myappconverter.java.applicationservices.CGGeometry;
import com.myappconverter.java.applicationservices.CGPoint;
import com.myappconverter.java.applicationservices.CGRect;
import com.myappconverter.java.coregraphics.CGAffineTransform;
import com.myappconverter.java.foundations.NSCoder;
import com.myappconverter.java.foundations.NSString;
import com.myappconverter.java.uikit.UIColor;
import com.myappconverter.java.uikit.UIFont;
import com.myappconverter.java.uikit.UIImage;
import com.myappconverter.java.uikit.UIImageView;
import com.myappconverter.java.uikit.UILabel;
import com.myappconverter.java.uikit.UIView;

public class UITetrisView extends
		com.magahern.charles.UITetris.uitetris.uitetris.UITetrisView {


	public UITetrisView(ViewGroup vg) {
		super(vg);
	}

	public UITetrisView() {
		super();
	}

	/**
	 * Method : initialize <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void tInitialize() {
		this.setBackgroundColor(UIColor.blackColor());
		this.setBlockSize(15);
		this.setBoardIsDirty(true);
	}

	/**
	 * Method : init <!-- begin-user-doc -->
	 * 
	 * @return UITetrisView.
	 * @generated
	 */
	public UITetrisView init() {
		super.init();
		if (this != null) {
			this.tInitialize();
		}
		return this;
	}

	/**
	 * Method : initWithCoder <!-- begin-user-doc -->
	 * 
	 * @return UITetrisView.
	 * @generated
	 */
	public UITetrisView initWithCoder(NSCoder aDecoder) {
		super.initWithCoder(aDecoder);
		if (this != null) {
			this.tInitialize();
		}
		return this;
	}

	/**
	 * Method : initWithFrame <!-- begin-user-doc -->
	 * 
	 * @return UITetrisView.
	 * @generated
	 */
	public UITetrisView initWithFrame(CGRect frame) {
		super.initWithFrame(frame);
		if (this != null) {
			this.tInitialize();
			UIImageView bg = (UIImageView) (new UIImageView())
					.initWithImage(UIImage.imageNamed(new NSString(
							"tetris_board.png")));
			bg.setFrame(CGRect.CGRectMake(0.0f, 0.0f, bg.frame().size.width,
					bg.frame().size.height));
			this.insertSubviewAtIndex(bg, 0);
			bg.release();
			float boardWidth = blockSize * 10;
			float boardHeight = blockSize * 20;
			CGRect gameBoardRect = CGGeometry.CGRectMake(
					frame.size.width / 8.0f + 3.0f, frame.size.height / 2.0f
							- boardHeight / 2.0f + 25.0f, boardWidth,
					boardHeight);
			_gameBoardView = new UIView();
			_gameBoardView.initWithFrame(gameBoardRect);
			_gameBoardView.setClipsToBounds(true);
			_gameBoardView.setBackgroundColor(UIColor.blueColor());
			_gameBoardView.setTag(7777);
			this.addSubview(_gameBoardView);
			_scoreLabel = new UILabel();
			_scoreLabel.init();
			_scoreLabel.setTextAlignment(NSText.NSTextAlignmentCenter);
			_scoreLabel.setFont(UIFont.boldSystemFontOfSize(32.0f));
			_scoreLabel.setTextColor(UIColor.whiteColor());
			_scoreLabel.setBackgroundColor(UIColor.clearColor());
			_scoreLabel.setText(new NSString("000"));
			_scoreLabel.sizeToFit();
			_scoreLabel.setCenter(CGGeometry.CGPointMake(241.0f, 375.0f));
			_scoreLabel.setFrame(new CGRect(214, 355, 54, 15));
			this.addSubview(_scoreLabel);
			float nextWidth = blockSize * 4 + 20.0f;
			float nextHeight = (blockSize / 2.0f) * 4 + 20.0f;
			CGRect nextDisplayRect = CGGeometry.CGRectMake(
					this.getBounds().size.width - this.getBounds().size.width
							/ 8.0f - nextWidth, gameBoardRect.origin.y,
					nextWidth, nextHeight);
			_nextTetronimoView = new UIView();
			_nextTetronimoView.initWithFrame(nextDisplayRect);
			_nextTetronimoView.setClipsToBounds(true);
			_nextTetronimoContentView = new UIView();
			_nextTetronimoContentView.initWithFrame(CGGeometry.CGRectMake(0.0f,
					0.0f, nextDisplayRect.size.width,
					nextDisplayRect.size.height));
			_nextTetronimoView.addSubview(_nextTetronimoContentView);
			this.addSubview(_nextTetronimoView);
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
	 * Method : willMoveToSuperview <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void willMoveToSuperview(UIView newSuperview) {
		_scoreLabel.setText(new NSString("0"));
		this.updateNextTetronimoDisplay(game.nextTetronimo());
	}

	/**
	 * Method : updateNextTetronimoDisplay <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void updateNextTetronimoDisplay(final UITetronimo tetronimo) {
		if (!com.myappconverter.java.foundations.ExpressNullable
				.assertCondition(_nextTetronimoView)
				|| !com.myappconverter.java.foundations.ExpressNullable
						.assertCondition(_nextTetronimoContentView)) {
			return;
		}
		final UITetrisBlock[] blocks = tetronimo.blocks();

		final UIViewBlock viewBlockCompilation = new UIViewBlock() {
			public void perform(boolean f) {
				if (com.myappconverter.java.foundations.ExpressNullable
						.assertCondition(true)) {
					for (Object oldImageViewInter : _nextTetronimoContentView
							.subviews()) {
						UIImageView oldImageView = (UIImageView) oldImageViewInter;
						if (oldImageView.tag() == 1337) {
							oldImageView.removeFromSuperview();
						}
					}
					float tetWidth;
					float tetHeight;
					float blkXOffset;
					float blkYOffset;
					CGPoint nextTetOrigin;
					tetWidth = blockSize
							* (tetronimo.getType() == UITetronimo.UITetronimoType.UITetronimoTypeI ? 4
									: 3);
					tetHeight = blockSize
							* (tetronimo.getType() == UITetronimo.UITetronimoType.UITetronimoTypeI ? 1
									: 2);
					nextTetOrigin = CGGeometry.CGPointMake(
							_nextTetronimoView.getBounds().size.width / 2.0f
									- tetWidth / 2.0f,
							_nextTetronimoView.getBounds().size.height / 2.0f
									- tetHeight / 2.0f);
					blkXOffset = (tetronimo.getType() == UITetronimo.UITetronimoType.UITetronimoTypeI ? 0.0f
							: (tetronimo.getType() == UITetronimo.UITetronimoType.UITetronimoTypeO ? -0.5f
									: -1.0f));
					blkYOffset = -1.0f;
					for (int i = 0; i < 4 * 4; i++) {
						if (blocks[i] != null) {
							UIImageView imageView = (new UIImageView())
									.initWithImage(blocks[i].imageView.image());
							imageView.setFrame(new CGRect(nextTetOrigin.x
									+ ((i % 4) + blkXOffset) * blockSize,
									nextTetOrigin.y + ((i / 4) + blkYOffset)
											* blockSize, blockSize, blockSize));
							imageView.setTag(1337);
							_nextTetronimoContentView.addSubview(imageView);
							imageView.release();
						}
					}
					_nextTetronimoContentView
							.setTransform(CGAffineTransform
									.CGAffineTransformMakeTranslation(
											0.0f,
											_nextTetronimoContentView.bounds().size.height));
					UIView.animateWithDurationAnimations(0.1f,
							new UIViewBlock() {
								@Override
								public void perform() {
									_nextTetronimoContentView
											.setTransformForAnimation(CGAffineTransform
													.CGAffineTransformMakeTranslation(
															0.0f, 0.0f));
									_nextTetronimoContentView.commitAnimation(
											0.1, this, null);

								}

								@Override
								public void perform(boolean finished) {
									// TODO Auto-generated method stub

								}
							});
				}
			}

			@Override
			public void perform() {
				// TODO Auto-generated method stub

			}
		};
		UIView.animateWithDurationAnimationsCompletion(0.1, new UIViewBlock() {
			public void perform() {
				_nextTetronimoContentView.setTransformForAnimation(CGAffineTransform
						.CGAffineTransformMakeTranslation(0.0f,
								-_nextTetronimoContentView.bounds().size.height));
				_nextTetronimoContentView.commitAnimation(0.1, this,
						viewBlockCompilation);
			}

			@Override
			public void perform(boolean finished) {
				// TODO Auto-generated method stub

			}
		}, viewBlockCompilation);
	}

	/**
	 * Method : setScore <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void setScore(long score) {
		_scoreLabel.setText(NSString
				.stringWithFormat(new NSString("%d"), score));
	}

	/**
	 * Method : animateClearLinesAtRows <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void animateClearLinesAtRows(long[] rows, long count) {
		UIView animationView;
		float posY;
		for (int i = 0; i < count; i++) {
			posY = rows[i] * blockSize;
			animationView = new UIView();
			animationView.initWithFrame(CGGeometry.CGRectMake(0.0f, posY,
					_gameBoardView.getBounds().size.width, blockSize));
			animationView.setBackgroundColor(UIColor.whiteColor());
			animationView.setAlpha(0.0f);
			_gameBoardView.addSubview(animationView);
			final UIView fanimationView = animationView;
			final UIViewBlock secondBlock = new UIViewBlock() {
				@Override
				public void perform(boolean f) {
					if (com.myappconverter.java.foundations.ExpressNullable
							.assertCondition(f)) {
						fanimationView.removeFromSuperview();
						fanimationView.release();
					}
				}

				@Override
				public void perform() {
					// TODO Auto-generated method stub

				}
			};
			final UIViewBlock complestionBlock = new UIViewBlock() {
				@Override
				public void perform(boolean f) {
					if (com.myappconverter.java.foundations.ExpressNullable
							.assertCondition(f)) {
						UIView.animateWithDurationAnimationsCompletion(0.1f,
								new UIViewBlock() {
									@Override
									public void perform() {
										fanimationView
												.setTransformForAnimation(CGAffineTransform
														.CGAffineTransformMakeScale(
																1.5f, 1.5f));
										fanimationView
												.setAlphaForAnimation(0.0f);
										fanimationView.commitAnimation(0.1f,
												this, secondBlock);
									}

									@Override
									public void perform(boolean finished) {
										// TODO Auto-generated method stub

									}
								}, secondBlock);
					}
				}

				@Override
				public void perform() {
					// TODO Auto-generated method stub

				}
			};
			UIView.animateWithDurationAnimationsCompletion(0.08f,
					new UIViewBlock() {
						@Override
						public void perform() {
							fanimationView.setAlphaForAnimation(1.0f);
							fanimationView.commitAnimation(0.08f, this,
									complestionBlock);
						}

						@Override
						public void perform(boolean finished) {
							// TODO Auto-generated method stub

						}
					}, complestionBlock);
		}
	}

	/**
	 * Method : _drawBlock <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void _drawBlock(UITetrisBlock block, int xPos, int yPos) {
		if (block == null) {
			return;
		}
		float drawX;
		float drawY;
		CGRect blockRect;
		drawX = xPos * blockSize;
		drawY = yPos * blockSize;
		blockRect = CGGeometry.CGRectMake(drawX, drawY, blockSize, blockSize);
		if (block.imageView != null) {
			if (block.imageView.getFrame().origin.x != drawX
					|| block.imageView.getFrame().origin.y != drawY) {
				block.imageView.setFrame(blockRect);
			}
			if (block.imageView.superview == null) {
				_gameBoardView.addSubview(block.imageView);
			}
		}
	}

	/**
	 * Method : _drawBlock <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void _drawBlock(UITetrisBlock block, int position) {
		int xPos;
		int yPos;
		xPos = position % 10;
		yPos = position / 10;
		this._drawBlock(block, xPos, yPos);
	}

	/**
	 * Method : _drawBlocks <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void _drawBlocks() {
		UITetrisBlock[] blocks = game.gameBoard();
		for (int i = 0; i < 20 * 10; i++) {
			if (blocks[i] != null) {
				this._drawBlock(blocks[i], i);
			}
		}
		this.setBoardIsDirty(false);
	}

	/**
	 * Method : _drawFallingTetronimo <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void _drawFallingTetronimo() {
		UITetronimo tet = game.fallingTetronimo;
		UITetrisBlock[] tetblocks = tet.blocks();
		int xPos;
		int yPos;
		if (tet == null) {
			return;
		}
		for (int i = 0; i < 4 * 4; i++) {
			if (tetblocks[i] != null) {
				xPos = tet.getXPosition() + (i % 4);
				yPos = tet.getYPosition() + (i / 4);
				this._drawBlock(tetblocks[i], xPos, yPos);
			}
		}
	}

	/**
	 * Method : redraw <!-- begin-user-doc -->
	 * 
	 * @return void.
	 * @generated
	 */
	public void redraw() {
		this._drawFallingTetronimo();
		if (com.myappconverter.java.foundations.ExpressNullable
				.assertCondition(boardIsDirty)) {
			this._drawBlocks();
		}
	}

}
