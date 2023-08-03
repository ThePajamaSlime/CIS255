//
//  Question.swift
//  PersonalityQuiz
//
//  Created by Student on 7/31/23.
//

import Foundation

struct Question {
    var text: String
    var type: ResponseType
    var answers: [Answer]
}

enum ResponseType {
    case single, multiple, ranged
}

struct Answer {
    var text: String
    var type: CountryType
    
}

enum CountryType: Character {
    case US = "🇺🇸", UK = "🇬🇧", JP = "🇯🇵", MX = "🇲🇽"
    
    var definition: String {
        switch self {
        case .US:
            return "You despise walking and love football, but were distracted by a McDonalds on your way to the stadium."
            
        case .UK:
            return "You've got a mouth like saltwater and don't take too kindly to good weather."
        case .JP:
            return "You live to work and subsist soley on rice and tea."
        case .MX:
            return "You possess more scars than tangible objects and that makes you a big, strong person. Good job."
        }
    }
}
