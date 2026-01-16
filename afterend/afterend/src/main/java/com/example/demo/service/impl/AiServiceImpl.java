package com.example.demo.service.impl;

import com.example.demo.service.AiService;
import com.volcengine.ark.runtime.model.completion.chat.ChatCompletionContentPart;
import com.volcengine.ark.runtime.model.completion.chat.ChatCompletionRequest;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessage;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessageRole;
import com.volcengine.ark.runtime.service.ArkService;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class AiServiceImpl implements AiService {
    // 从环境变量中获取您的 API Key。此为默认方式，您可根据需要进行修改
    String apiKey = "c9aa8433-44c1-417a-b75e-cc095754da69";
    // 此为默认路径，您可根据业务所在地域进行配置
    String baseUrl = "https://ark.cn-beijing.volces.com/api/v3";
    ConnectionPool connectionPool = new ConnectionPool(5, 1, TimeUnit.SECONDS);
    Dispatcher dispatcher = new Dispatcher();
    ArkService service = ArkService.builder().dispatcher(dispatcher).connectionPool(connectionPool).baseUrl(baseUrl).apiKey(apiKey).build();
    @Override
    public String chat(String question) {
        StringBuffer buffer = new StringBuffer();
        System.out.println("----- image input request -----");
        final List<ChatMessage> messages = new ArrayList<>();
        final List<ChatCompletionContentPart> multiParts = new ArrayList<>();

        multiParts.add(ChatCompletionContentPart.builder().type("text").
                text(question).build());
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

        System.out.println(buffer.toString());

        service.shutdownExecutor();
        return buffer.toString();
    }

    @Override
    /**
     * 图片输入并提问
     * @param imgUrl 图片地址
     *               question 问题
     */
    public String chat(String imgUrl, String question) {
        StringBuffer buffer = new StringBuffer();
        System.out.println("----- image input request -----");
        final List<ChatMessage> messages = new ArrayList<>();
        final List<ChatCompletionContentPart> multiParts = new ArrayList<>();
        multiParts.add(ChatCompletionContentPart.builder().type("image_url").imageUrl(
                new ChatCompletionContentPart.ChatCompletionContentPartImageURL(imgUrl)
        ).build());
        multiParts.add(ChatCompletionContentPart.builder().type("text").text(question).build());
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
        System.out.println("============================================");//要回答的结果
        System.out.println(buffer.toString());

        service.shutdownExecutor();
        return buffer.toString();
    }
}
