

# 摄像机(Camera)

（Unity2018.4.3f1）

![Cmaera
](E:/StudyNotes/Picture/UnityStudy/Camera.png)


---

## 参数详解

根据项目使用的渲染管线，unity 在Camera Inspector 中显示不同的属性。

1. <font color=green>通用渲染管线（URP）</font>
2. <font color=green>高清渲染管线（HDRP）</font>
3. <font color=green>内置渲染管线</font>

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
  - <font color=red>Far</font>: 远裁剪面， 相当于摄像机的最远绘制点。
- **Viewport Rect**: 标准视图矩形。用四个数值来控制摄像机的视图在屏幕上的位置。
  -   *X* : 绘制摄像机视图的起始水平位置。
  -  *Y*  : 绘制摄像机视图的起始垂直位置。
  -  *W* : 屏幕上摄像机输出的宽度。
  -  *H* : 屏幕上摄像机输出的高度。
- **Depth**：摄像机在绘制顺序中的位置。具有更大值的摄像机将绘制在具有更小值的摄像机之上。
- **Rendering Path**：定义摄像机使用的渲染方法，有以下四种
  - *Use Player Settings*：此摄像机将使用 Player Settings 中设置的任何渲染路径 (Rendering Path)。
  -  *Vertex Lit*：此摄像机渲染的所有对象都将渲染为顶点光照对象。
  - *Forward*：快速渲染。摄像机将所有游戏对象将按每种材质一个通道的方式来渲染。对于实时光影来说， Forward的消耗比Deferred更高,，但是Forward更加适合用于半烘焙半实时的项目。Forward解决了一个Deferred没能解决的问题.。那就是Deferred不能让Mixed模式的DirectionalLight将动态阴影投射在一个经过烘焙了的静态物体上。
  - *Deferred Lighting* ： Unity5多了一种RenderingPath，可以取代过去的Legacy Deferred. 最大的特点是对于实时光影来说的性能消耗更低了，这个模式是最适合动态光影的。对于次时代PC或者主机游戏, 当然要选择这个。通过Viking Village以及”进化”这些最新游戏的观察我发现次时代游戏几乎不需要烘焙光照贴图了, 全都使用实时阴影是很好的选择.。通过阴影距离来控制性能消耗。而在Viking Village的场景中，由于整个场景全部使用了动态光源，Forward的Rendering方面的性能消耗要比Deferred高出一倍！ 因此在完全使用动态光源的项目中千万不能使用Forward。
- **Target Texture**：目标纹理。用于将摄像机视图输出并渲染到屏幕。一般用于制作导航图或者画中画等效果。设置此引用将禁用此摄像机的渲染到屏幕功能。
- **Occlusion Culling**：为此摄像机启用遮挡剔除 (Occlusion Culling)。遮挡剔除意味着隐藏在其他对象后面的对象不会被渲染。
- **Allow HDR**：允许渲染高动态色彩画面。如果相机正在使用HDR渲染，则为True;如果不是，则为false。即使此属性为true，也仅在当前图形层支持使用HDR。
- **Allow MSAA**：摄像机启用多重采样抗锯齿，允许进行硬件抗锯齿。
- **Allow Dynamic Resolution**：摄像机启用动态分辨率渲染，如果相机使用动态分辨率渲染，则为True;如果不是，则为false。即使此属性为true，也仅在当前图形设备也支持使用动态分辨率。
- **Target Display**：此设置使Camera渲染到指定的显示中，定义要渲染到的外部设备。值为 1 到 8 之间。

参考文档：

1. [Unity 官方开发手册](https://docs.unity.cn/cn/2018.4/Manual/class-Camera.html)

2. [Unity3D摄像机Camera参数详解](https://blog.csdn.net/weixin_42513339/article/details/83010862)

   
   
---
# Unity 生命周期函数

![生命周期函数图](https://images2017.cnblogs.com/blog/1284555/201711/1284555-20171129220355167-1445128134.jpg)

<font color=red>Unity 3D 中的生命周期函数</font>

**生命周函数**：需要继承 MonoBehaviour 类才能使用。生命周期函数全部都是由系统定义好的，系统会自动调用，且调用顺序与在代码中的书写顺序无关


## 常用的生命周期函数

**<font color=red>Awake()</font>**: 唤醒事件，游戏一开始运行就执行，只执行一次。

**<font color=red>OnEnable()</font>**: 启用事件，只执行一次，当脚本组件被启用的时候执行一次。

**<font color=red>Start()</font>**: 开始事件，执行一次。

**<font color=red>FiexdUpdate()</font>**: 固定更新事件，执行N次，每物理帧(0.02s)执行一次。所有物理相关的更新都在这个事件中处理。

**<font color=red>Update()</font>**： 更新事件，执行N次，每帧执行一次。

**<font color=red>LateUpdate()</font>**: 稍后更新事件，执行N次，在Update()事件执行完毕后在再执行。

**<font color=red>OnGUI()</font>**: GUI渲染事件，执行N次，执行的次数是Update()事件的两倍。

**<font color=red>OnDisable()</font>**: 禁用事件，执行一次。在OnDestory()事件前执行。或者当该脚本组件被"禁用"后，也会出发该事件。


**<font color=red>OnDestory()</font>**: 销毁事件，执行一次。当脚本所挂载的游戏物体被销毁时执行。


## 一、Editor

### Reset
    void Reset()  
    {
        
    }
    

调用Reset是在用户点击检视面板的Reset按钮或者首次添加该组件时被调用。此函数只在编辑模式下被调用，Reset最常用于在检视面板中给定一个最常用的默认值。

    public GameObject target;
    void Reset(){
        target = GameObject.FindWithTag("Player");
    }

### OnValidate

**OnValidate**: 每当设置脚本的属性时都会调用OnValidate,包括反序列化对象时，这可能发生在不同的时间，例如在编辑器中打开场景时和域重新加载后。


## 二、Initialization

### void Awake()

    void Awake(){
        
    }
    
 当一个脚本实例被载入时Awake被调用。Awake用于在游戏开始之前初始化变量或游戏状态。在脚本整个生命周期内它仅被调用一次Awake在所有对象被初始化之后调用，所以可以安全的与其他对象或用GameObject.FindWithTag这类的函数搜索它们。<font color=green>每个游戏物体上的 Awake 以随机的顺序被调用。Awake 像构造函数一样只被调用一次。 Awake 总是在 Start 之前被调用。</font>
 
 ### void OnEnable()
 
    void OnEnable(){
        
    }

当对象变为可用或激活状态时此函数被调用，OnEnable 不能用于协同程序。


    using UnityEngine;
    using System.Collections;
    public class OnEnabledTest : MonoBehaviour{
        void OnEnable(){
            print("This script was enable");
        }
    }
    
### void Start()


    void Start(){
        
    }
    

Start 仅在Update 函数第一次被调用前调用，在 behaviour 的生命周期中只被调用一次，它和 Awake的不同是 Start只在脚本实例被启用时调用。可以按需调整延迟初始化代码。<font color=green> Awake 总是在Start 之前执行，允许你协调初始化顺序，在游戏运行过程中实例化对象时，不能强制执行此调用，初始化目标变量，目标是私有的并且不能在检视面板中编辑。</font>

    using UnityEngine;
    using System.Collections;
    public class StartTest : MonoBehaviour
    {
        private GameObject target;
        
        void Start(){
            target = GameObject.FindWithTag("Player");
        }
        
    }

## 三、Physics

### void FixedUpdate()

    void FixedUpdate()
    {
        
    }  

固定更新 void FixedUpdate() 处理基于物理游戏行为一般用该方法，处理 Rigidbody时， 需要用到 fixedUpdate 代替 Update 。当 MonoBehaviour 启用时，其FixedUpdate 在每一帧被调用。在FixedUpdate 内应用运动计算时，无需将值乘以 Time.deltaTime，因为FixedUpdate 的调用基于可靠的计时器(独立于帧率)。

例如：给刚体加一个作用力时，必须应用作用力在 FixedUpdate 里的固定帧，而不是Update中的帧。（两者帧长不同）每帧应用一个向上的力到刚体上

    using UnityEngine;
    using System.Collections;
    public class Example : MonoBehaviour
    {
        void FixedUpdate()
        {
            rigidbody.AddForce(Vector3.up);
        }
    }

### void OnTriggerXXX(Collider other)

    void OnTriggerXXX(Collider other)
    {
        
    }
    
 
进入触发器 void OnTriggerEnter(Collider other) 当 Collider(碰撞体) 进入 trigger(触发器)时调用 OnTriggerEnter。

逗留触发器 void OnTriggerStay(Collider other) 当碰撞体接触触发器时，OnTriggerStay 将在每一帧被调用。

退出触发器 void OntriggerExit(Collider other) 当Collider(碰撞体)停止触发trigger(触发器)时调用OnTriggerExit。

### void OnCollisionXXX (Collision collisionInfo)


    void OnCollisionXXX (Collision collisionInfo){
        
    }
    

进入碰撞 void OnCollisionEnter (Collision collisionInfo),当此collider/rigidbody触发另一个rigidbody/collider时，OnCollisionEnter将会在开始碰撞时调用。


逗留碰撞 void OnCollisionStay (Collision collisionInfo),当此collider/rigidbody触发另一个rigidbody/collider时，OnCollisionStay将会在每一帧被调用。


退出碰撞 void OnCollisionExit (Collision collisionInfo),当此collider/rigidbody停止触发另一个rigidbody/collider时，OnCollisionExit将被调用。


Collision包含接触点,碰撞速度等细节。如果在函数中不使用碰撞信息，省略collisionInfo参数以避免不必要的运算.

### yieldWaitForFixUpdate



## 四、Input events

### void OnMouseXXX()

    void OnMouseXXX(){
        
    }
    

<font color=red>void OnMouseUp()</font>: 当用户释放鼠标按钮时调用OnMouseUp。OnMouseUp只调用在按下的同一物体上。此函数在iPhone上无效。

<font color=red>void OnMouseDown()</font>: 当鼠标在Collider(碰撞体)上点击时调OnMouseDown。

<font color=red>void OnMouseEnter()</font>: 当鼠标进入到Collider(碰撞体)中时调用OnMouseEnter。

<font color=red>void OnMouseExit()</font>: 当鼠标移出Collider(碰撞体)上时调用OnMouseExit。

<font color=red>void OnMouseOver()</font>: 当鼠标悬浮在Collider(碰撞体)上时调用 OnMouseOver 。

实例代码：

    using UnityEngine;
    using System.Collections;
    public class OnMouseXXX : MonoBehaviour {
        void OnMouseEnter()
        {
            Debug.Log(“当鼠标进入”);
        }
            void OnMouseDown()
        {
            Debug.Log(“当鼠标按下”);
        }
        void OnMouseDrag()
        {
            Debug.Log(“当鼠标拖动”);
        }   
        void OnMouseExit()
        {
            Debug.Log(“当鼠标推出”);
        }
        void OnMouseOver()
        {
            Debug.Log(“当鼠标经过”);
        }
    }

## 五、Game Logic

### void Update()

    void Update()
    {
        
    }

当MonoBehaviour启用时，其Update在每一帧被调用，UPdate是实现各种游戏行为最常用的函数。

    using UnityEngine;
    using System.Collections;
    public class UpdateTest : MonoBehaviour
    {
        void Update()
        {
            transform.Translate(0,0,Time.deltaTime * 2f);
        }
    }
    

### void LateUpdate()

    void LateUpdate()
    {
        
    }
    
当Behaviour启用时，其LateUpdate在每一帧被调用，LateUpdate是在所有Update函数调用后被调用。这可用于调整脚本执行顺序。

例如：当物体在Update里移动时，跟随物体的相机可以在LateUpdate里实现。


### yield null

### yield WaitForSeconds

### yield WWW

### yield StartCoroutine


## 六、Scene rendering

### OnWillRenderObject

<font color=red>OnWillRenderObject</font>:如果对象可见，则为每个相机调用一次此函数。

### OnPreCull
<font color=red>OnPreCull</font>:在相机剔除场景之前调用此函数。相机可见的对象取决于剔除。OnPreCull 函数调用发生在剔除之前。

### OnBecameVisible
<font color=red>OnBecameVisible/OnBecameInvisible</font>:在对象对于相机可见/不可见时调用此函数。

### OnPreRender
<font color=red>OnPreRender</font>:在相机开始渲染场景之前调用此函数。

### OnRenderObject
<font color=red>OnRenderObject</font>:在完成所有常规场景渲染后调用此函数。此时，可使用GL类或Graphics.DrawMeshNow绘制自定义几何图形。

### OnPostRender
<font color=red>OnPostRender</font>:在相机完成场景渲染后调用此函数。

### OnRenderImage
<font color=red>OnRenderImage</font>:在完成场景渲染后调用此函数，以便对屏幕图像进行后期处理。


## 七、Gizemo rendering

### void OnDrawGizmos()
    
    void OnDrawGizmos(){
        
    }
    
OnDrawGizmos只在编辑模式下被调用

OnDrawGizmos 用于在场景视图中绘制小图示(Gizmos),以实现可视化目的。

## 八、GUI rendering

### void OnGUI()

    void OnGUI(){
       if( GUI.BUtton(new Rect(10,10,150,100),"I am a Button")){  
           print("You clicked the button!")
       }
    }

OnGUI在每一帧更新时调用多次，以响应GUI事件。程序首先将处理Layout和RePaint事件，然后再处理每个输入事件的Layout和keyboard/鼠标事件。

## 九、End of frame

### yieldWaitForEndOfFrame()

## 十、Pausing 

### void OnApplicationPause()

    void OnApplicationPause(){
        
    }

OnApplicationPause()在程序检测到暂停时，会在帧的结尾被调用

## 十一、Disable/enable

### void OnDisaable()

    void OnDisable()
    {
        
    }

当对象变为不可用或非激活状态时此函数被调用。当物体被销毁时它将被调用，并且可用于任意清理代码。脚本被卸载时，OnDisable将被调用，OnEnable在脚本被载入后调用。

## 十二、Decommissioning

### void OnDestroy()
当MonBehaviour将被销毁时，这个函数被调用。OnDestory只会在 预先已经被激活的游戏物体上被调用。

### OnApplicationQuit
当程序退出后调用

---
参考文档：

1. [Unity 官方开发手册](https://docs.unity.cn/cn/2018.4/Manual/class-Camera.html)

2. [博客园](https://www.cnblogs.com/xiaoyulong/p/7922985.html#)

3. [Unity全部生命周期函数总结](https://blog.csdn.net/weixin_44048531/article/details/109753440)


