import pandas as pd

# Read CSV
df = pd.read_csv('diem_thi_thpt_2024.csv')

# Extract students
students = df[['sbd', 'ma_ngoai_ngu']].drop_duplicates()
students.columns = ['student_id', 'no_language']  # change column names
students.to_csv('students.csv', index=False)

# Extract scores
subjects = ['toan', 'ngu_van', 'ngoai_ngu', 'vat_li', 'hoa_hoc', 'sinh_hoc', 'lich_su', 'dia_li', 'gdcd']
scores = []
for i, subject in enumerate(subjects, 1):
    temp = df[['sbd', subject]].dropna()
    temp['subject'] = subject
    temp.columns = ['student_id', 'score', 'subject'] # change column names
    scores.append(temp[['student_id', 'subject', 'score']])
scores_df = pd.concat(scores)
scores_df.to_csv('scores.csv', index=False)