//
//  QuestionViewController.swift
//  PersonalityQuiz
//
//  Created by Khamanei Ainsworth Thursday, August 3, 2023
//
//  Last submission of the semester!! Great teaching, Mr. Nelson!

import UIKit


class QuestionViewController: UIViewController {
    
    func updateSingleStack(using answers: [Answer]) {
        singleStackView.isHidden = false;
        
        singleButton1.setTitle(answers[0].text, for: .normal)
        singleButton2.setTitle(answers[1].text, for: .normal)
        singleButton3.setTitle(answers[2].text, for: .normal)
        singleButton4.setTitle(answers[3].text, for: .normal)
        
    }
    
    func updateMultipleStack(using answers: [Answer]) {
        multipleStackView.isHidden = false;
        
        multiSwitch1.isOn = false
        multiSwitch2.isOn = false
        multiSwitch3.isOn = false
        multiSwitch4.isOn = false
        
        multiLabel1.text = answers[0].text
        multiLabel2.text = answers[1].text
        multiLabel3.text = answers[2].text
        multiLabel4.text = answers[3].text
    }
    
    func updateRangedStack(using answers: [Answer]) { rangedStackView.isHidden = false
        
        rangedBar.setValue(0.5, animated: false)
        
        rangedLabel1.text = answers.first?.text
        rangedLabel2.text = answers.last?.text
        
    }
    
    func updateUI() {
        singleStackView.isHidden = true
        multipleStackView.isHidden = true
        rangedStackView.isHidden = true
        
        navigationItem.title = "Question #\(questionIndex+1)"

        let currentAnswers = currentQuestion.answers
        let totalProgress = Float(questionIndex) / Float(maxQuestionsCount)

        
        switch currentQuestion.type {
        case .single:
           updateSingleStack(using: currentAnswers)
        case .multiple:
            updateMultipleStack(using: currentAnswers)
        case .ranged:
            updateRangedStack(using: currentAnswers)
        }
        
        questionLabel.text = currentQuestion.text
        
        progressBar.setProgress(totalProgress, animated: true)
    }

    override func viewDidLoad() {
        super.viewDidLoad()
            
        maxQuestionsCount = questions.count
        nextQuestion()
    }
    
    var questions: [Question] = [
        Question(text: "What do you often eat?", type: .single, answers: [Answer(text: "Hamburger", type: .US), Answer(text: "Canned Noodle in a Cup", type: .JP), Answer(text: "Nothing Sandwich", type: .MX), Answer(text: "Tea and swear words", type: .UK)]),
        Question(text: "How do you move?", type: .multiple, answers: [Answer(text: "Tire machine", type: .US), Answer(text: "Train express", type: .JP), Answer(text: "Cockney Cab", type: .UK), Answer(text: "Foot mobile", type: .MX)]),
        Question(text: "How poor?", type: .ranged, answers: [Answer(text: "Very", type: .MX), Answer(text: "Not very", type: .US)])
        ]
    
    var questionIndex = 0
    var maxQuestionsCount = 0
    
    // assign currentQuestion to some "empty" value
    // removes the "class has no initializers" error
    var currentQuestion: Question = Question(text: "", type: .single, answers: [Answer(text: "", type: .US)])
    var answersChosen: [Answer] = []
    
    func nextQuestion() {
        if questions.isEmpty == false {
            questionIndex += 1
            currentQuestion = questions.remove(at: Int.random(in: 0..<questions.count))
            updateUI()
        }
        else {
            performSegue(withIdentifier: "Results", sender: nil)
        }
    }
    
    @IBAction func singleAnswerButtonPressed(_ sender: UIButton) {
        let currentAnswers = currentQuestion.answers
        
        switch sender {
        case singleButton1:
            answersChosen.append(currentAnswers[0])
        case singleButton2:
            answersChosen.append(currentAnswers[1])
        case singleButton3:
            answersChosen.append(currentAnswers[2])
        case singleButton4:
            answersChosen.append(currentAnswers[3])
        default:
            answersChosen.append(currentAnswers[666])
        }
        
        nextQuestion()
    }
    
    @IBAction func multipleAnswersButtonPressed() {
        let currentAnswers = currentQuestion.answers
        
        if multiSwitch1.isOn {
            answersChosen.append(currentAnswers[0])
        }
        if multiSwitch2.isOn {
            answersChosen.append(currentAnswers[1])
        }
        if multiSwitch3.isOn {
            answersChosen.append(currentAnswers[2])
        }
        if multiSwitch4.isOn {
            answersChosen.append(currentAnswers[3])
        }
        
        nextQuestion()
    }
    
    @IBAction func rangedAnswerButtonPressed() {
        let currentAnswers = currentQuestion.answers
        
        let index = Int(round(rangedBar.value * Float(currentAnswers.count - 1)))
        
        answersChosen.append(currentAnswers[index])
        
        nextQuestion()
    }
    
    
    @IBOutlet var singleStackView: UIStackView!
    // single button items
    @IBOutlet var singleButton1: UIButton!
    
    @IBOutlet var singleButton2: UIButton!
    
    @IBOutlet var singleButton3: UIButton!
    
    @IBOutlet var singleButton4: UIButton!
    
    @IBOutlet var multipleStackView: UIStackView!
    
    @IBOutlet var multiLabel1: UILabel!
    @IBOutlet var multiLabel2: UILabel!
    @IBOutlet var multiLabel3: UILabel!
    @IBOutlet var multiLabel4: UILabel!
    
    
    @IBOutlet var multiSwitch1: UISwitch!
    
    @IBOutlet var multiSwitch2: UISwitch!
    
    @IBOutlet var multiSwitch3: UISwitch!
    
    @IBOutlet var multiSwitch4: UISwitch!
    
    
    @IBOutlet var rangedStackView: UIStackView!
    
    @IBOutlet var rangedLabel1: UILabel!
    @IBOutlet var rangedLabel2: UILabel!
    
    @IBOutlet var rangedBar: UISlider!
    
    
    @IBOutlet var questionLabel: UILabel!
    
    @IBOutlet var progressBar: UIProgressView!
    
    
    @IBSegueAction func showResults(_ coder: NSCoder) -> ResultsViewController? {
        return ResultsViewController(coder: coder, responses: answersChosen)
    }
    
   
    
    
    
    
    
    
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
