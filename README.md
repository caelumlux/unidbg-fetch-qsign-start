# unidbg-fetch-qsign
本程序已经停更,请支持腾讯官方机器人OpenAPI

# 须知
 - 请勿使用本程序进行各种违规违法行为,一切行为造成的后果与开发者和仓库主无关.
 - 由于项目的特殊性，我们可能~~随时删除本项目~~且不会做出任何声明

# 切记

 - 公共API具有高风险可能
 - QSign基于Android平台，其它平台Sign计算的参数不同，不互通(例如：IPad)请注意)。
 - 支持载入Tim.apk的so文件。
 - 本仓库囊括了手Q8988及企点582及tim355等txlib
 - 本程序囊括了tlv544~553,以及各种sign,请看HTTP API根目录的调用规范
   
# 使用API

## [初始化QSign&刷新token](https://github.com/TeaBoss-Developer/unidbg-fetch-qsign/blob/master/refresh_token/README.md)

### 原始energy

```kotlin
# http://host:port/custom_energy?uin=[QQ]&salt=[SALT HEX]&data=[DATA]
```
| 参数名 | 意义      | 例子     |
|-----|---------|--------|
| UIN | Bot的QQ号 | 114514 |

> 非专业人员勿用。

### sign

```kotlin
# http://host:port/sign?uin=[UIN]&qua=[QUA]&cmd=[CMD]&seq=[SEQ]&buffer=[BUFFER]
```
| 参数名    | 意义                                                | 例子                          |
|--------|---------------------------------------------------|-----------------------------|
| UIN    | Bot的QQ号                                           | 114514                      |
| QUA    | QQ User-Agent，与QQ版本有关                             | V1_AND_SQ_8.9.68_4264_YYB_D |
| CMD    | 指令类型，CMD有很多种，目前登录、发信息均需要sign                      | wtlogin.login               |
| SEQ    | 数据包序列号，用于指示请求的序列或顺序。它是一个用于跟踪请求的顺序的数值，确保请求按正确的顺序处理 | 2333                        |
| BUFFER | 数据包包体，不需要长度，将byte数组转换为HEX发送                       | 020348010203040506          |

<details>
<summary>POST的支持</summary>

如果buffer过长，会超出get请求方式的长度上限，因此sign的请求也支持POST的方式。

请求头 `Content-Type: application/x-www-form-urlencoded`

POST的内容："uin=" + uin + "&qua=" + qua + "&cmd=" + cmd + "&seq=" + seq + "&buffer=" + buffer
</details>

### 登录包energy(tlv544)

下面这个只是个例子

```kotlin
# http://host:port/energy?version=[VERSION]&uin=[UIN]&guid=[GUID]&data=[DATA]
```

| 参数名     | 意义                                                           | 例子                               |
|---------|--------------------------------------------------------------|----------------------------------|
| VERSION | **注意！**这里的VERSION指的**不是QQ的版本号，而是SDK Version**，可以在QQ安装包中找到此信息 | 6.0.0.2549                       |
| UIN     | Bot的QQ号                                                      | 114514                           |
| GUID    | 登录设备的GUID，将byte数组转换为HEX发送，必须是32长度的HEX字符串                     | ABCDABCDABCDABCDABCDABCDABCDABCD |
| DATA    | QQ发送登录包的CmdId和SubCmdId，例子中810是登陆CmdId，9是SubCmdId             | 810_9                            |


