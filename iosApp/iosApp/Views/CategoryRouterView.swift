//
//  CategoryRouterView.swift
//  iosApp
//
//  Created by Venkatesh Maganahalli on 8/29/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct CategoryRouterView: View {
    
    var category : String
    
    var body: some View {
        if category == "Movies" {
           DisplayMoviesView()
        }else {
            UnderConstructionView()
        }
    }
}

struct CategoryRouterView_Previews: PreviewProvider {
    static var previews: some View {
        CategoryRouterView(category: "Movies")
    }
}
