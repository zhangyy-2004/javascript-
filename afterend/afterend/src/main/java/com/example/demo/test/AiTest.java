package com.example.demo.test;

import com.volcengine.ark.runtime.model.completion.chat.ChatCompletionContentPart;
import com.volcengine.ark.runtime.model.completion.chat.ChatCompletionRequest;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessage;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessageRole;
import com.volcengine.ark.runtime.service.ArkService;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AiTest {
    // 从环境变量中获取您的 API Key。此为默认方式，您可根据需要进行修改
    static String apiKey = "c9aa8433-44c1-417a-b75e-cc095754da69";
    // 此为默认路径，您可根据业务所在地域进行配置
    static String baseUrl = "https://ark.cn-beijing.volces.com/api/v3";
    static ConnectionPool connectionPool = new ConnectionPool(5, 1, TimeUnit.SECONDS);
    static Dispatcher dispatcher = new Dispatcher();
    static ArkService service = ArkService.builder().dispatcher(dispatcher).connectionPool(connectionPool).baseUrl(baseUrl).apiKey(apiKey).build();
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();//定义一个变量
        System.out.println("----- image input request -----");
        final List<ChatMessage> messages = new ArrayList<>();
        final List<ChatCompletionContentPart> multiParts = new ArrayList<>();
//        multiParts.add(ChatCompletionContentPart.builder().type("image_url").imageUrl(
//                new ChatCompletionContentPart.ChatCompletionContentPartImageURL(
//                        "https://gips3.baidu.com/it/u=1022347589,1106887837&fm=3028&app=3028&f=JPEG&fmt=auto?w=960&h=1280"
//                )
//        ).build());
        multiParts.add(ChatCompletionContentPart.builder().type("text").text(
                "河南的美食有哪些？"
        ).build());
        final ChatMessage userMessage = ChatMessage.builder().role(ChatMessageRole.USER)
                .multiContent(multiParts).build();
        messages.add(userMessage);
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest.builder()
                // 指定您创建的方舟推理接入点 ID，此处已帮您修改为您的推理接入点 ID
                .model("doubao-seed-1-6-251015")
                .messages(messages)
                .reasoningEffort("medium")
                .build();
        service.createChatCompletion(chatCompletionRequest).getChoices().forEach(choice -> buffer.append(choice.getMessage().getContent()));
        System.out.println("============================================");
        System.out.println(buffer.toString());
//        System.out.println("----- streaming request -----");
//        final List<ChatMessage> streamMessages = new ArrayList<>();
//        final List<ChatCompletionContentPart> multiParts1 = new ArrayList<>();
//        multiParts1.add(ChatCompletionContentPart.builder().type("image_url").imageUrl(
//                new ChatCompletionContentPart.ChatCompletionContentPartImageURL(
//                        "https://ark-project.tos-cn-beijing.ivolces.com/images/view.jpeg"
//                )
//        ).build());
//        multiParts1.add(ChatCompletionContentPart.builder().type("text").text(
//                "这是哪里？"
//        ).build());
//        final ChatMessage userMessage1 = ChatMessage.builder().role(ChatMessageRole.USER)
//                .multiContent(multiParts1).build();
//        messages.add(userMessage1);
//        ChatCompletionRequest streamChatCompletionRequest = ChatCompletionRequest.builder()
//                // 指定您创建的方舟推理接入点 ID，此处已帮您修改为您的推理接入点 ID
//                .model("doubao-seed-1-6-251015")
//                .messages(messages)
//                .reasoningEffort("medium")
//                .build();
//        service.streamChatCompletion(streamChatCompletionRequest)
//                .doOnError(Throwable::printStackTrace)
//                .blockingForEach(
//                        choice -> {
//                            if (choice.getChoices().size() > 0) {
//                                System.out.print(choice.getChoices().get(0).getMessage().getContent());
//                            }
//                        }
//                );
        service.shutdownExecutor();
    }
}
