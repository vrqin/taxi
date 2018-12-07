# taxi


**仅作学习用途**

类似滴滴打车的网约车平台，Spring + Jersey + Hibernate 的 RESTful WebService ，Mina 维护长连接，ActiveMQ 负责服务间的通信解耦。

乘客通过客户端发起打车订单，司机通过客户端接单。

* ectaxi : 网约车平台后台管理系统 WebService。
* taxi-e ：
    * smartkab
        * smartkab-server：
        	* 我也不知道这个是干嘛的。
        * smartkab-ws：基础 WebService。
        	* 开启 MQ 接收 `engine_to_ws` 队列的GPS消息，更新司机字典的GPS数据（当前位置信息，免得查表）。
        	* 提供用户，订单，位置等Resources的 WebService。
	        	* 收到新订单的POST请求（包含位置信息），推送订单到 `ws_to_engine` 队列，保存订单。
	        	* 收到接受订单的PUT请求，更新数据库。
	        	* 收到取消订单的PUT请求，更新数据库，推送订单到 `ws_to_engine` 队列。
	        	* 收到上传位置信息的POST请求，更新数据库，推送订单位置到 `ws_to_engine` 队列。
    * smartkab-client：客户端（模拟）。
        * smartkab-client-driver：客户端（司机）模拟。
    * smartkab-order：订单服务引擎。
        * smartkab-order-engine：订单服务引擎服务器，维护和客户端的长连接。
            * 初始化：
                * 查询数据库，初始化司机字典，更新司机位置信息等，初始化未完成订单队列。
                * 初始化 Mina 长连接，Handler，接受订单、GPS消息。
                 	* 长连接收到Login包，更新司机字典，保存`IoSession`。
                    * 长连接收到GPS包，保存到数据库，更新司机字典位置信息，并通过 MQ 发送GPS数据到队列。
					* 长连接收到Logout包，略。
					* 长连接收到PayInfo包，更新数据库订单消息，通过 MQ 推送到 `engine_to_score` 队列计算积分。
					* 长连接收到NewOrder包，emmm，更新数据库。
					* 长连接收到AcceptOrder包，emmm，发信息，更新数据库。
					* 长连接收到DropOrder包，emmm，发信息，更新数据库。
					* 长连接收到OrderTrack包，emmm，更新接单后GPS数据到数据库，如果到达了，将订单轨迹推送到 `engine_to_score` 队列计算积分。
					* 还有更改密码什么的，略。
                * 开一个线程启动订单 MQ，接受新订单消息、取消订单消息（都是通过一个 `while` 循环）。
                	* 收到新订单消息：丢进未完成订单队列。
                	* 收到取消订单消息：将订单从等待订单字典移除，通过 `IoSession` 发送给客户端结果。
                * 开一个线程启动支付 MQ，接受 `pay_to_engine` 队列支付结果消息，通过 `IoSession` 发送给客户端。
                * 开一个线程更新等待订单状态。
                * 开一个线程监听配置XMl变化。
                * 开一个线程检查不能接单的司机。
                * 开一个线程发送系统通知（通过司机字典保存的 `IoSession`）。
                * 开一个线程检查禁止接单的司机。
                * 开一个线程下发订单给司机：循环`poll`未完成订单队列，从司机字典计算出附件的司机，派单给他们。

        * smartkab-order-protocol：通信协议包的定义及一些工具。
        * smartkab-order-ws：订单服务引擎的 WebService，查询有用没用的东西。
    * smartkab-pay：支付服务。
        * smartkab-pay-alipay：支付宝支付依赖。
        * smartkab-pay-wechat：微信支付依赖。
        * smartkab-pay-ws：支付服务 WebService，响应支付API请求，并通过 MQ 推送订单到 `pay_to_engine` 队列。
    * smartkab-score-ws：积分服务，计算支付、里程的积分，接受 MQ 推送到 `engine_to_score` 队列的消息，保存到数据库。
    



挺多相同功能都有 HTTP POST 和 TCP 长连接两个接口的，比如接单，额，大概就是这样吧。

