

# 摄像机(Camera)

（Unity2018.4.3f1）

![Camera](C:\Users\zj\Pictures\UnityStudy\Unity2018Camera.png.jpg)



---

## 参数详解

- **Clear Flags**:	确定将清除屏幕的哪些部分，使用多个摄像机来绘制不同游戏对象的情况。每个摄像机在渲染其视图时都会存储颜色和深度信息。屏幕中未绘制的部分为空，默认情况下将显示天空盒(Skybox)。使用多个摄像机时，每个摄像机都会在缓存区中存储自己的颜色和深度信息，随着每个摄像机渲染而累积越来越多数据。场景中的任何特定摄像机渲染其视图时，可以设置**Clear Flags** 来清除不同的缓冲区信息集合，有以下四个选择：

  - <font color=red>Skybox</font>
    - 这是默认设置。屏幕中任意空白部分将显示当前摄像机的天空盒。默认为Lighting窗口(菜单-->Window-->Rendering-->Lighting Settings)中选择的天空盒。随后，它将恢复为背景颜色（**Background Color**）。也可以将Skybox组件添加到摄像机。创建新的天空盒
  - <font color=red>Solid color</font>
    - 屏幕的任何空白部分都将显示为当前相机的**背景颜色**
  - <font color=red>Depth only</font>
    - Depth表示渲染深度，可以理解为摄像机显示顺序，Depth值越大，渲染越靠后，在场景中优先显示，当多个摄像机Depth值相同时，它们同时渲染，只显示最后一个摄像机所拍摄的内容，其他被遮挡，可以调整 **Viewport Rect** 属性，使同一层下多摄像机内容同时显示。该模式用于游戏对象不希望被裁剪的情况。
  - <font color=red>Dont Clear</font>
    - 此模式不会清除颜色或深度缓冲区。结果是**将每帧绘制在下一帧之上**，从而实现涂抹效果。此模式通常不用于游戏，一般与自定义的shader配合使用。在某些GPU(主要是移动端GPU)上，不清除屏幕可能会导致其内容在下一帧未定义。

- **Background**

  - 在绘制视图中的所有元素之后但没有天空盒的情况下，应用于剩余屏幕部分的颜色。

- **Culling Mask**(剔除遮罩)

  - 剔除遮罩，选择所要显示的layer(层级)，可使用层来选择性渲染对象组

- **Projection**(投射方式)

  - <font color=red>Perspective</font>(透视):	摄像机将用透视的方式来渲染游戏对象。透视视图和我们从眼睛看到的视图是一样。用于3D游戏
    - <font color=yellow>Field of view</font>: 视野范围。用于控制摄像机的视角宽度以及纵向的角度尺寸。
  - <font color=red>orthographic</font>(正交)：摄像机将均匀渲染对象，没有透视感。无法判断物体大小。注意：在正交模式下不支持延迟渲染。始终使用前向渲染。
    - <font color=yellow>Size</font>:大小。用于控制正交模式摄像机的视口大小。

- **Physical Camera**(物理相机)：默认不勾选，启用后模拟真实摄像机属性

  - <font color=red>Focal Length</font>: 设置摄像机传感器和摄像机镜头之间的距离（以毫米为单位），较小的值产生更宽的 **Filed of View ** ，反之亦然。更改此值，Unity会相应自动更新 **Filed of View** 属性。

  -  ***Sensor Type***：指定希望摄像机模拟的真实摄像机格式。从列表中选择所需的格式。选择摄像机格式时，Unity 会自动将 **Sensor Size > X** 和 **Y** 属性设置为正确的值。如果手动更改 **Sensor Size** 值，Unity 会自动将此属性设置为 **Custom**。

  - ***Sensor Size***：设置摄像机传感器的大小（以毫米为单位）。选择 **Sensor Type** 时，Unity 会自动设置 **X** 和 **Y** 值。如果需要，可以输入自定义值。

    - X : 传感器的宽度。
    - Y : 传感器的高度。

  - ***Lens Shift***: 从中心水平或垂直移动镜头。值是传感器大小的倍数；例如，在 X 轴上平移 0.5 将使传感器偏移其水平大小的一半。可使用镜头移位来校正摄像机与拍摄对象成一定角度时发生的失真（例如，平行线会聚）。沿任一轴移动镜头均可使摄像机视锥体[倾斜](https://docs.unity.cn/cn/2018.4/Manual/ObliqueFrustum.html)。

    - X : 传感器水平偏移。
    - Y : 传感器垂直偏移。

  - ***Gate Fit***: 用于更改**分辨率门**大小（Game 视图的大小/宽高比）相对于**胶片门**大小（物理摄像机传感器的大小/纵横比）的选项。

    -    *Vertical*: 使分辨率门适应胶片门的高度。如果传感器宽高比大于 Game 视图宽高比，Unity 会在两侧裁剪渲染的图像。如果传感器宽高比小于 Game 视图宽高比，Unity 会在两侧对渲染的图像进行过扫描。选择此设置时，更改传感器宽度（**Sensor Size > X 属性**）不会影响渲染的图像。
    - *Horizontal*: 使分辨率门适应胶片门的宽度。如果传感器宽高比大于 Game 视图宽高比，Unity 会在顶部和底部对渲染的图像进行过扫描。如果传感器宽高比小于 Game 视图宽高比，Unity 会在顶部和底部裁剪渲染的图像。选择此设置时，更改传感器高度（**Sensor Size > Y** 属性）不会影响渲染的图像。
    -    *Fill*: 使分辨率门适应胶片门的宽度或高度（以较小者为准）。这会裁剪渲染的图像。
    - *Overscan*: 使分辨率门适应胶片门的宽度或高度（以较大者为准）。这会过扫描 (overscan) 渲染的图像。

    - *None*: 忽略分辨率门，仅使用胶片门。这会拉伸渲染的图像以适应 Game 视图宽高比。

- **Clipping Planes**: 剪切平面。摄像机开始渲染与停止渲染之间的距离。

  - <font color=red>Near</font>:近裁剪面， 相当于摄像机的最近绘制点。
  - <font color=red>Far</font>: 远裁剪面，

