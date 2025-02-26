import math

radius = 0.465
num_points = 36

coordinates = []

for i in range(num_points):
    angle = 2 * math.pi * i / num_points
    x = radius * math.cos(angle)
    y = radius * math.sin(angle)
    z = 0  # Since the center is at (0, 0, 0)
    if x > y:
        coordinates.append((x-0.025, y, z))
        coordinates.append((x+0.025, y, z))
    else:
        coordinates.append((x, y-0.025, z))
        coordinates.append((x, y+0.025, z))

# Print the coordinates
for coordinate in coordinates:
    print(f"{coordinate[0]:.4f} {coordinate[1]:.4f} {coordinate[2]:.4f}")