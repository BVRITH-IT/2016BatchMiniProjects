import flask
import pickle
import pandas as pd
import numpy as np
from sklearn.preprocessing import MinMaxScaler
with open('model/loan_model_xgboost.pkl', 'rb') as f:
    model = pickle.load(f)
app = flask.Flask(__name__, template_folder='templates')
@app.route('/', methods=['GET', 'POST'])
def main():
    x=0
    y=0
    z=0
    if flask.request.method == 'GET':
        return(flask.render_template('main.html'))
    if flask.request.method == 'POST':
        Age = flask.request.form['Age']
        Experience = flask.request.form['Experience']
        Income = flask.request.form['Income']
        Family = flask.request.form['Family']
        CCAvg = flask.request.form['CCAvg']
        Mortgage = flask.request.form['Mortgage']
        SecuritiesAccount = flask.request.form['SecuritiesAccount']
        CDAccount = flask.request.form['CDAccount']
        CreditCard = flask.request.form['CreditCard']
        Education = flask.request.form['Education']
        if(Education=="1"):
            x=1
        if(Education=="2"):
            y=1
        if(Education=="3"):
            z=1
        input_variables = pd.DataFrame([[Age,Experience,Income,Family,CCAvg,Mortgage,SecuritiesAccount,CDAccount,CreditCard, x, y, z]],
                                      columns=['Age','Experience','Income','Family','CCAvg','Mortgage','SecuritiesAccount','CDAccount','CreditCard','12th', 'Bachelors','Masters'],
                                      dtype=float)
        prediction = model.predict(input_variables)[0]
        return flask.render_template('main.html',
                                     original_input={'Age':Age,'Experience':Experience,'Income':Income,'Family':Family,'CCAvg':CCAvg,'Mortgage':Mortgage,'SecuritiesAccount':SecuritiesAccount,'CDAccount':CDAccount,'CreditCard':CreditCard, '12th':x, 'Bachelors':y, 'Masters':z},
                                     result=prediction,
                                     )
if __name__ == '__main__':
    app.run(debug=True)