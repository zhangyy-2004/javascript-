let isOpen = false
const messages = []
let messageIdCounter = 1
let baseUrl="http://127.0.0.1/ai/chat"

// DOM elements
const chatButton = document.getElementById("chatButton")
const chatWindow = document.getElementById("chatWindow")
const closeButton = document.getElementById("closeButton")
const messagesContainer = document.getElementById("messagesContainer")
const messageInput = document.getElementById("messageInput")
const sendButton = document.getElementById("sendButton")
const timestamp = document.getElementById("timestamp")

// Initialize
function init() {
  updateTimestamp()

  // Event listeners
  chatButton.addEventListener("click", openChat)
  closeButton.addEventListener("click", closeChat)
  sendButton.addEventListener("click", handleSendMessage)
  messageInput.addEventListener("keypress", handleKeyPress)
  messageInput.addEventListener("input", updateSendButton)

  updateSendButton()
}

function openChat() {
  isOpen = true
  chatButton.classList.add("hidden")
  chatWindow.classList.remove("hidden")
}

function closeChat() {
  isOpen = false
  chatWindow.classList.add("hidden")
  chatButton.classList.remove("hidden")
}

function updateTimestamp() {
  const now = new Date()
  const timeString = `今天 ${now.getHours().toString().padStart(2, "0")}:${now.getMinutes().toString().padStart(2, "0")}`
  timestamp.textContent = timeString
}

function addMessage(text, isUser = false, hasButtons = false) {
  const messageId = messageIdCounter++
  const message = {
    id: messageId,
    text: text,
    isUser: isUser,
    timestamp: new Date(),
    hasButtons: hasButtons,
  }

  messages.push(message)
  renderMessage(message)
  scrollToBottom()
}

function renderMessage(message) {
  const messageDiv = document.createElement("div")
  messageDiv.className = `message animate-fade-in ${message.isUser ? "user" : ""}`

  if (message.isUser) {
    messageDiv.innerHTML = `
            <div class="message-bubble user">
                ${message.text}
            </div>
        `
  } else {
    messageDiv.innerHTML = `
            <div class="avatar">小e</div>
            <div>
                <div class="message-bubble">
                    ${message.text}
                </div>
                ${
                  message.hasButtons
                    ? `
                    <div class="button-group">
                        <button class="choice-btn" onclick="handleNoResponse()">不是</button>
                        <button class="choice-btn" onclick="handleYesResponse()">是</button>
                    </div>
                `
                    : ""
                }
            </div>
        `
  }

  messagesContainer.appendChild(messageDiv)
}

function handleSendMessage() {
  const inputValue = messageInput.value.trim()
  if (!inputValue) return

  addMessage(inputValue, true)
  messageInput.value = ""
  updateSendButton()

  // Auto reply after 1 second
  setTimeout(() => {
    addMessage("请稍等，小e正在努力思索中~^_^~")
  }, 1000)
  //
  
  let url = baseUrl + "?question=" + inputValue
  axios.get(url)
  .then(res=>{
	  addMessage(res.data);
  })
  .catch();
}



function handleKeyPress(e) {
  if (e.key === "Enter") {
    handleSendMessage()
  }
}

function updateSendButton() {
  const hasValue = messageInput.value.trim().length > 0
  sendButton.disabled = !hasValue
}

// function handleYesResponse() {
//   addMessage("好的，我将为您提供法律咨询服务。请详细描述您遇到的法律问题，我会尽力为您解答。")
// }

// function handleNoResponse() {
//   addMessage("了解了，那请问您需要咨询什么其他问题呢？我可以帮您找商品、找供应商或其他采购相关的问题。")
// }

function scrollToBottom() {
  messagesContainer.scrollTop = messagesContainer.scrollHeight
}

// Initialize when page loads
document.addEventListener("DOMContentLoaded", init)
