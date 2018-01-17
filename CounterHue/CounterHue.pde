PImage img;
float sum = 0;
float mean = 0;
void setup() {
  size(1000, 1000);
  img = loadImage("1.png");

  //int[] hist = new int[256];
  //colorMode(HSB, 100);

  img.loadPixels();
  //// Calculate the histogram
  //for (int i = 0; i < img.width; i++) {
  //  for (int j = 0; j < img.height; j++) {
  //    int hue = int(hue(get(i, j)));
  //    sum = sum + hue;
  //  }
  //}
  for (int i =0; i < img.pixels.length; i++){
    sum = sum + hue(img.pixels[i]);
  }

  //float parcels = img.width * img.height;
  //mean = sum/parcels;
  //println(mean);

  //  fill(mean, 255, 255);
  //  rect(0, 0, 1000, 1000);

  //  // Find the largest value in the histogram
  //  int histMax = max(hist);

  //stroke(255);
  //// Draw half of the histogram (skip every second value)
  //for (int i = 0; i < img.width; i += 2) {
  //  // Map i (from 0..img.width) to a location in the histogram (0..255)
  //  int which = int(map(i, 0, img.width, 0, 255));
  //  // Convert the histogram value to a location between 
  //  // the bottom and the top of the picture
  //  int y = int(map(hist[which], 0, histMax, img.height, 0));
  //  strokeWeight(4);
  //  stroke(0, 0, 0);
  //  line(i, img.height, i, y);
  //}
}

void draw() {
  background(255);
  image(img, 0, 0);
  rectMode(CENTER);
  int mX = mouseX;
  int mY = mouseY;
  float hue = hue(get(mX, mY));
  float brt = brightness(get(mX, mY));
  float sat = saturation(get(mX, mY));
  fill(0);
  text(hue + "", mX, mY);
  noStroke();
  fill(extractColorFromImage(img));
  rect(mX, mY, 10, 10);
}

color extractColorFromImage(PImage img) {
    img.loadPixels();
    int r = 0, g = 0, b = 0;
    for (int i=0; i<img.pixels.length; i++) {
        color c = img.pixels[i];
        r += c>>16&0xFF;
        g += c>>8&0xFF;
        b += c&0xFF;
    }
    r /= img.pixels.length;
    g /= img.pixels.length;
    b /= img.pixels.length;
 
    return color(r, g, b);
}