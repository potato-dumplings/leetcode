package june;

public class June1401 {

    public static boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // 圆形变正方形。
        // 求圆的直径的长、高。
        int diameter = radius * 2 + 1;
        boolean[][] circle2Rectangle = new boolean[diameter][diameter];

        // 填充正方形未铺满的上半区域。未铺用true表达，正常应该用false表达。
        int a = 0;
        for (int y = 0; y < radius; y++) {
            for (int x = 0; x < radius - a; x++ ) {
                circle2Rectangle[y][x] = true;
            }
            for (int x = radius * 2; x > radius + a; x--) {
                circle2Rectangle[y][x] = true;
            }
            ++a;
        }
        a = 0;
        for (int y = radius * 2; y > radius; y--) {
            for (int x = 0; x < radius - a; x++ ) {
                circle2Rectangle[y][x] = true;
            }
            for (int x = radius * 2; x > radius + a; x--) {
                circle2Rectangle[y][x] = true;
            }
            ++a;
        }

        int startX = xCenter - radius;
        int endX = xCenter + radius;
        int startY = yCenter - radius;
        int endY = yCenter + radius;
        // 1、检查矩形是否包含圆形。
        if (x1 >= startX && endX <= x2 && y1 >= startY && y2 <= endY) {
            return true;
        }

        // 2、检查矩形的左侧边长是否被圆形包裹
        // 3、检查矩形的顶部边长是否被圆形包裹
        // 4、检查矩形的底部边长是否被圆形包裹
        // 5、检查矩形的右侧边长是否被圆形包裹


        // 都不包裹，返回false
        return false;
    }

    public static void main(String[] args) {
        checkOverlap(5, 0, 0, 1, -1, 3, 1);
    }


}
