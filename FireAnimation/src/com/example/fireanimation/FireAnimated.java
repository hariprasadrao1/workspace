/**
 * 
 */
package com.example.fireanimation;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class FireAnimated {

	private Bitmap bitmap; // the animation sequence
	private Rect sourceRect; // the rectangle to be drawn from the animation
								// bitmap
	private int frameNr; // number of frames in animation
	private int currentFrame; // the current frame
	private long frameTicker; // the time of the last frame update
	private int framePeriod; // milliseconds between each frame (1000/fps)

	private int spriteWidth; // the width of the sprite to calculate the cut out
								// rectangle
	private int spriteHeight; // the height of the sprite

	private int x; // the X coordinate of the object (top left of the image)
	private int y; // the Y coordinate of the object (top left of the image)
	Resources res;

	Bitmap bitmap1;

	public FireAnimated(Bitmap bitmap, int x, int y, int width, int height,
			int fps, int frameCount, Bitmap bitmap1) {
		this.bitmap = bitmap;
		this.x = x;
		this.y = y;
		currentFrame = 0;
		frameNr = frameCount;
		spriteWidth = bitmap.getWidth() / frameCount;
		spriteHeight = bitmap.getHeight() / 5;
		sourceRect = new Rect(0, 0, spriteWidth, spriteHeight);
		framePeriod = 1000 / fps;
		frameTicker = 0l;
		this.bitmap1 = bitmap1;

	}

	// the update method for Elaine
	public void update(long gameTime) {
		if (gameTime > frameTicker + framePeriod) {
			frameTicker = gameTime;
			// increment the frame
			currentFrame = ++currentFrame % 10;
			// currentFrame++;
			if (currentFrame >= frameNr) {
				currentFrame = 0;
			}
		}

		// define the rectangle to cut out sprite
		this.sourceRect.left = currentFrame * spriteWidth;
		this.sourceRect.right = this.sourceRect.left + spriteHeight;
	}

	// the draw method which draws the corresponding frame
	public void draw(Canvas canvas) {
		// where to draw the sprite

		Rect destRect = new Rect(x, y, x + spriteWidth, y + spriteHeight);
		canvas.drawBitmap(bitmap1, 0, 0, null);
		// big fire right side
		canvas.drawBitmap(bitmap, sourceRect, destRect, null);

		// right

		Rect s = new Rect(310, 155, 360, 230);
		canvas.drawBitmap(bitmap, sourceRect, s, null);
		// down
		Rect s1 = new Rect(130, 280, 180, 330);

		canvas.drawBitmap(bitmap, sourceRect, s1, null);

		// between two
		Rect s2 = new Rect(100, 180, 150, 230);

		canvas.drawBitmap(bitmap, sourceRect, s2, null);

		Rect s3 = new Rect(180, 180, 230, 230);

		canvas.drawBitmap(bitmap, sourceRect, s3, null);

		// small ones

		Rect s4 = new Rect(245, 145, 260, 170);

		canvas.drawBitmap(bitmap, sourceRect, s4, null);
		Rect s5 = new Rect(250, 180, 270, 205);

		canvas.drawBitmap(bitmap, sourceRect, s5, null);

		Rect s6 = new Rect(230, 230, 245, 245);

		canvas.drawBitmap(bitmap, sourceRect, s6, null);

	}
}
