//
//  ViewController.swift
//  Login
//
//  Created by Student on 7/17/23.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    @IBOutlet var UsernameField: UITextField!
    
    @IBOutlet var forgorPasswordButton: UIButton!
    
    @IBOutlet var forgorUsernameButton: UIButton!
    
    
    @IBAction func forgorPasswordButtonTap(_ sender: Any) {
        
        performSegue(withIdentifier: "forgorUserOrPass", sender: forgorPasswordButton)
    }
    
    @IBAction func forgorUsernameButtonTap(_ sender: Any) {
        
        performSegue(withIdentifier: "forgorUserOrPass", sender: forgorUsernameButton)
    }
    
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        guard let sender = sender as? UIButton else { return}
        
        if sender == forgorPasswordButton {
            segue.destination.navigationItem.title = "Forgor Password"
        }
        else if sender == forgorUsernameButton {
            segue.destination.navigationItem.title = "Forgor Username"
        }
        else {
        segue.destination.navigationItem.title = UsernameField.text
        }
        
    }


}

