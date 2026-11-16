# Cloud Computing Laboratory

[![Ubuntu](https://img.shields.io/badge/Ubuntu-24.04%20%2F%2026.04-E95420?style=for-the-badge&logo=ubuntu&logoColor=white)](https://ubuntu.com/)
[![VirtualBox](https://img.shields.io/badge/VirtualBox-7.0+-183A61?style=for-the-badge&logo=virtualbox&logoColor=white)](https://www.virtualbox.org/)
[![Mininet](https://img.shields.io/badge/Mininet-SDN%20Virtualization-brightgreen?style=for-the-badge)](http://mininet.org/)
[![Ryu](https://img.shields.io/badge/Ryu-SDN%20Controller-blue?style=for-the-badge)](https://ryu-sdn.org/)
[![CloudSim Plus](https://img.shields.io/badge/CloudSim%20Plus-8.5.5-orange?style=for-the-badge)](https://cloudsimplus.org/)
[![AWS](https://img.shields.io/badge/AWS-Cloud%20Services-FF9900?style=for-the-badge&logo=amazon-aws&logoColor=white)](https://aws.amazon.com/)
[![Render](https://img.shields.io/badge/Render-PaaS%20Deployment-46E3B7?style=for-the-badge&logo=render&logoColor=black)](https://render.com/)
[![Apache Hadoop](https://img.shields.io/badge/Apache%20Hadoop-3.x%20MapReduce-66CCFF?style=for-the-badge&logo=apache-hadoop&logoColor=black)](https://hadoop.apache.org/)

A comprehensive, production-grade repository documenting laboratory experiments, configuration steps, code implementations, troubleshooting guides, and execution results for a university **Cloud Computing** curriculum.

---

## 📚 Table of Contents & Laboratory Index

| Lab | Topic | Cloud Model / Domain | Key Technologies & Tools | Documentation | Code & Artifacts |
| :---: | :--- | :--- | :--- | :---: | :---: |
| **Lab 1** | **Ubuntu Virtual Machine Setup & Troubleshooting** | Infrastructure as a Service (IaaS) | Oracle VirtualBox, Ubuntu Linux, `build-essential` | [Lab 1 Guide](./Lab%201/README.md) | Configuration & Logs |
| **Lab 2** | **Client-Server Socket Communication Between VMs** | Cloud Networking & IPC | Python 3 Sockets, VirtualBox NAT Network, TCP/IP | [Lab 2 Guide](./Lab%202/README.md) | [`server.py`](./Lab%202/server.py), [`client.py`](./Lab%202/client.py) |
| **Lab 3** | **Network Topology Emulation Using Mininet** | Network Virtualization (NFV) | Mininet, Open vSwitch, Python CLI | [Lab 3 Guide](./Lab%203/README.md) | Topologies (Single, Linear, Tree, Reversed) |
| **Lab 4** | **Software-Defined Networking (SDN) with Ryu Controller** | Programmable Networks (SDN) | Mininet, Open vSwitch, Ryu Controller, OpenFlow 1.3 | [Lab 4 Guide](./Lab%204/README.md) | Flow Rules & Python 3 Compatibility Patches |
| **Lab 5** | **Cloud Resource Scheduling Simulation** | Datacenter Resource Management | Java 17, Apache Maven, CloudSim Plus 8.5.5 | [Lab 5 Guide](./Lab%205/README.md) | [`pom.xml`](./Lab%205/pom.xml), [`SchedulingExperiment.java`](./Lab%205/src/main/java/lab/SchedulingExperiment.java) |
| **Lab 6** | **AWS Cloud Services & Management Operations** | Public Cloud (IaaS & PaaS) | AWS (S3, EC2, VPC, IAM, CloudWatch, CloudShell CLI) | [Lab 6 Guide](./Lab%206/README.md) | AWS CLI Scripts |
| **Lab 7** | **Collaborative Applications in the Cloud** | Software as a Service (SaaS) | Google Workspace (Docs, Sheets, Slides, Drive) | [Lab 7 Guide](./Lab%207/README.md) | Multi-User Edits & Version History Auditing |
| **Lab 8** | **Application Deployment on Cloud PaaS** | Platform as a Service (PaaS) | Python Flask, Gunicorn, GitHub CI/CD, Render PaaS | [Lab 8 Guide](./Lab%208/README.md) | [`main.py`](./Lab%208/main.py), [`requirements.txt`](./Lab%208/requirements.txt) |
| **Lab 9** | **MapReduce Application on Hadoop Cluster Setup** | Distributed Big Data Processing | Apache Hadoop 3.x, HDFS, YARN, Java 17, MapReduce | [Lab 9 Guide](./Lab%209/README.md) | [`WordCount.java`](./Lab%209/WordCount.java), [`input.txt`](./Lab%209/input.txt) |

---

## 🗂️ Repository Structure

```text
Cloud-Computing/
├── README.md                                  # Repository overview and lab index
├── .gitignore                                 # Git ignore rules for build artifacts and virtualenvs
│
├── Lab 1/                                     # Lab 1: VM Provisioning & Setup
│   ├── README.md                              # Illustrated walkthrough & troubleshooting guide
│   ├── Ubuntu_VM_Setup.md                     # Markdown lab report
│   └── *.png, *.jpeg                          # 12 proof-of-work screenshots
│
├── Lab 2/                                     # Lab 2: TCP Socket Communication Between VMs
│   ├── README.md                              # Illustrated step-by-step socket guide
│   ├── TCP_Application.md                     # Markdown lab report
│   ├── server.py                              # Server socket implementation
│   ├── client.py                              # Client socket implementation
│   └── *.png                                  # 8 proof-of-work screenshots
│
├── Lab 3/                                     # Lab 3: Mininet Virtual Network Topologies
│   ├── README.md                              # Illustrated Mininet topology guide
│   ├── Mininet.md                             # Markdown lab report
│   └── *.png                                  # 10 proof-of-work screenshots
│
├── Lab 4/                                     # Lab 4: Software-Defined Networking (SDN)
│   ├── README.md                              # Ryu Controller, OVS & OpenFlow 1.3 guide
│   ├── SDN.md                                 # Markdown lab report with Python 3.14 patches
│   └── *.png                                  # 8 proof-of-work screenshots
│
├── Lab 5/                                     # Lab 5: CloudSim Plus Scheduling Simulation
│   ├── README.md                              # Simulation methodology & results guide
│   ├── cloud_scheduling_lab.md                # Markdown lab report
│   ├── pom.xml                                # Maven build definition with CloudSim Plus 8.5.5
│   ├── src/main/java/lab/
│   │   └── SchedulingExperiment.java          # Java simulation source (Scenarios A-D)
│   └── *.png                                  # 7 proof-of-work screenshots
│
├── Lab 6/                                     # Lab 6: Amazon Web Services (AWS)
│   ├── README.md                              # AWS Console & CloudShell CLI practical guide
│   ├── lab_6.md                               # Markdown lab report
│   └── *.png                                  # 8 proof-of-work screenshots
│
├── Lab 7/                                     # Lab 7: SaaS Collaborative Applications
│   ├── README.md                              # Google Workspace SaaS collaboration guide
│   ├── lab_7.md                               # Markdown lab report
│   └── *.png                                  # 6 proof-of-work screenshots
│
├── Lab 8/                                     # Lab 8: Render PaaS Web Application Deployment
│   ├── README.md                              # Flask web deployment & continuous delivery guide
│   ├── render_paas.md                         # Markdown lab report
│   ├── main.py                                # Python Flask application (Version 1 & 2)
│   ├── requirements.txt                       # Application dependencies (Flask, Gunicorn)
│   └── *.png                                  # 10 proof-of-work screenshots
│
└── Lab 9/                                     # Lab 9: Apache Hadoop MapReduce Cluster
    ├── README.md                              # Cluster setup & MapReduce WordCount guide
    ├── lab_9.md                               # Markdown lab report
    ├── WordCount.java                         # Java MapReduce Mapper, Reducer, and Driver
    ├── input.txt                              # Sample dataset for HDFS processing
    └── *.png                                  # 15 proof-of-work screenshots
```

---

## 🛠️ Technology Stack & Environment

| Layer | Tools & Technologies Used |
| :--- | :--- |
| **Operating Systems** | Ubuntu Linux (24.04 / 26.04 LTS), Oracle Linux |
| **Virtualization** | Oracle VirtualBox 7.x, NAT Networking, Guest Additions |
| **Network Emulation & SDN** | Mininet 2.3+, Open vSwitch (`ovs-vsctl`, `ovs-ofctl`), Ryu SDN Controller, OpenFlow 1.3 |
| **Simulation Frameworks** | CloudSim Plus 8.5.5, Java 17 LTS, Apache Maven |
| **Public Cloud & PaaS** | Amazon Web Services (AWS S3, EC2, VPC, CloudWatch, CloudShell), Render PaaS |
| **Big Data & Distributed Computing** | Apache Hadoop 3.x (HDFS, YARN), Java MapReduce framework |
| **Programming Languages** | Python 3.10+ / 3.12+, Java 17, Bash Shell Scripting |

---

## 🚀 Quick Start & Lab Navigation

### 1. Virtual Machine & Networking Labs (Labs 1–4)
- **[Lab 1: Ubuntu VM Setup & Troubleshooting](./Lab%201/README.md):** Build a 4 GB RAM / 3 CPU Linux VM in VirtualBox. Resolves `adcli` installer crashes, `vmwgfx` display conflicts, and Windows Hyper-V collisions.
- **[Lab 2: TCP Socket Communication](./Lab%202/README.md):** Configure a VirtualBox NAT network (`10.0.2.0/24`) connecting two VMs and run real-time bidirectional TCP chat scripts.
- **[Lab 3: Mininet Network Virtualization](./Lab%203/README.md):** Emulate Minimal, Single, Linear, Tree, and Reversed network topologies and evaluate reachability using `pingall`.
- **[Lab 4: Software-Defined Networking (SDN)](./Lab%204/README.md):** Connect Mininet to the Ryu SDN controller using OpenFlow 1.3, analyze dynamic flow tables, and enforce packet dropping rules via Open vSwitch.

### 2. Cloud Scheduling & Public Cloud Services (Labs 5–8)
- **[Lab 5: Cloud Resource Scheduling](./Lab%205/README.md):** Run Maven simulations comparing Space-Shared and Time-Shared policies for Host VM scheduling and Cloudlet task execution with CloudSim Plus.
- **[Lab 6: Amazon Web Services (AWS)](./Lab%206/README.md):** Hands-on public cloud exploration using S3 storage, EC2 compute instances, VPC networking, CloudWatch monitoring, and CloudShell CLI commands.
- **[Lab 7: Collaborative SaaS Applications](./Lab%207/README.md):** Multi-user real-time document editing, spreadsheet formulas, presentation design, and version history auditing in Google Workspace.
- **[Lab 8: Render PaaS Web Deployment](./Lab%208/README.md):** Deploy a Python Flask application via GitHub CI/CD to Render PaaS, monitor live HTTP request logs, and perform zero-downtime version upgrades.

### 3. Distributed Processing & Big Data (Lab 9)
- **[Lab 9: Hadoop Cluster & MapReduce](./Lab%209/README.md):** Configure a pseudo-distributed Hadoop cluster with HDFS and YARN daemons, format NameNode, build a Java WordCount MapReduce application, and monitor execution via web UIs (`localhost:9870`, `localhost:8088`).

---

## 📝 License & Academic Integrity
This repository is prepared for educational purposes under the Cloud Computing Laboratory course curriculum. All guides and code samples are tested and documented with verifiable execution outputs.
