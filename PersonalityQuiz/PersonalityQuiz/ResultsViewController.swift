//
//  ResultsViewController.swift
//  PersonalityQuiz
//
//  Created by Student on 7/26/23.
//

import UIKit

class ResultsViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        calcPersonalityResult()
        navigationItem.hidesBackButton = true
    }
    
    var responses: [Answer]
    
    init?(coder: NSCoder, responses: [Answer]) {
        self.responses = responses
        super.init(coder: coder)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    func calcPersonalityResult() {
        let answerFrequency = responses.reduce(into: [:]) {
            (counts, answer) in counts[answer.type, default:0] += 1
        }
        
        let mostCommonAnswer = answerFrequency.sorted { $0.1 > $1.1 }.first!.key
        
        bigLabel.text = "You are \(mostCommonAnswer.rawValue)!"
        littleLabel.text = mostCommonAnswer.definition
    }
    
    @IBOutlet var bigLabel: UILabel!
    
    @IBOutlet var littleLabel: UILabel!
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
