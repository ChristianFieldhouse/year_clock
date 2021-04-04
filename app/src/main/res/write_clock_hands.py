import numpy as np
def line(to):
    return (
        """
        <vector xmlns:android="http://schemas.android.com/apk/res/android"
            android:width="79.64dp"
            android:height="79.64dp"
            android:viewportWidth="79.64"
            android:viewportHeight="79.64">
          <path\n"""
              + f"\t\t\tandroid:pathData=\"M40.0,40.0 L{40+to[0]},{40+to[1]}\"\n"
              + """\t\t\tandroid:strokeLineJoin="miter"
              android:strokeWidth="1"
              android:fillColor="#00000000"
              android:strokeColor="#ffffff"
              android:strokeLineCap="butt"/>
        </vector>
        """
    )

for month in range(12):
    for day in range(31):
        with open(f"drawable/ic_clock_hand_{month}_{day}.xml", "w") as f:
            f.write(line([
                40 * np.sin((month * 31 + day) * 2 * np.pi / (12 * 31)),    
                40 * np.cos((month * 31 + day) * 2 * np.pi / (12 * 31)),
            ]))
