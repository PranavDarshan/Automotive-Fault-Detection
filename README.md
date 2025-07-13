# 🚗 AI-Powered Automotive Fault Detection System

## 🔍 Introduction

Modern vehicles are increasingly complex, requiring intelligent, proactive diagnostics to reduce downtime and ensure safety. This project leverages Artificial Intelligence and Machine Learning techniques for **real-time fault detection** and **predictive maintenance** in automotive systems.

The system combines a **TabNet deep learning model** with **LLM (LLaMA)** integration to monitor vehicle health via live sensor data. It features a responsive **React.js frontend** for visualization and a **Spring Boot backend** to handle data and model interactions.

Only frontend is deployed on the [vercel app](https://automotive-fault-detection.vercel.app/). Backend and database are not deployed.

---

## ⚙️ System Overview

**Key Components:**

- 🧠 **Machine Learning (TabNet)**: Predicts potential faults using time-series sensor data (temperature, RPM, pressure, etc.).
- 💬 **LLM (LLaMA)**: Provides user-friendly explanations and recommendations based on model predictions.
- 🌐 **Frontend**: Built with React.js to visualize real-time sensor readings and diagnostics.
- 🚀 **Backend**: Developed using Spring Boot to manage APIs, data flow, and model interactions.

---

## 🎯 Features

- Fault prediction and health diagnostics using AI
- Natural language-based recommendations via LLM
- Scalable architecture with support for multiple vehicle types
- Secure and responsive web dashboard

---

## 🗂️ Project Structure

```
Automotive-Fault-Detection-main/
├── SpringBootBackend/main_el/            # Spring Boot application
│   ├── src/
│   └── pom.xml
│
├── UI_React/           # React.js application
│   ├── src/
│   └── package.json
│
├── TabNetModel/              
├── app.py        # flask endpoint serving model
└── hhmodel.pkl   # trained model artifact
```

---

## 🚀 Getting Started

### ✅ Prerequisites

- Java 17+
- Node.js 16+
- Python 3.8+
- Maven
- Git

---

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/PranavDarshan/Automotive-Fault-Detection.git
cd Automotive-Fault-Detection-main
```

---

### 2️⃣ Start Backend (Spring Boot)

```bash
cd SpringBootBackend/main_el
mvn clean install
mvn spring-boot:run
```

- Runs on: `http://localhost:8080`

---

### 3️⃣ Start Frontend (React.js)

```bash
cd UI_React
npm install
npm start
```

- Runs on: `http://localhost:3000`
- Communicates with the backend APIs for real-time updates.

---

### 4️⃣ Train & Serve TabNet Model

```bash
cd TabNetModel
python app.py     # Optional Flask/FastAPI service
```

Dependencies:

```bash
pip install pytorch scikit-learn pytorch-tabnet
```

---

### 5️⃣ LLaMA LLM Integration (Optional)

Set up LLaMA or use an API wrapper to serve sensor insights. Update the backend config to point to the LLM service endpoint.

---

## 📈 Results

- ✅ High accuracy in predicting faults using TabNet.
- 📊 Real-time dashboard for system health monitoring.
- 💡 Natural language feedback improves decision-making.
- ⏱️ Reduced maintenance downtime and improved scheduling efficiency.

---

## 🧪 Testing & Validation

- Backend: `JUnit` + `SpringBootTest`
- Frontend: `Jest` + `React Testing Library`
- Model: Evaluated using Accuracy, Precision, Recall, and F1 Score
- User feedback incorporated to enhance UX and explainability

---

## 📌 Future Enhancements

- CAN-bus integration for real-world sensor streaming
- Multi-vehicle model training
- User authentication and dashboard personalization
- Full microservices deployment with Docker/Kubernetes

---

---

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

